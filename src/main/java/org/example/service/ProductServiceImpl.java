package org.example.service;

import org.example.dto.OrderDTO;
import org.example.dto.ProductDTO;
import org.example.exception.SoldOutException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductServiceImpl implements ProductService {

  private final List<ProductDTO> products = new ArrayList<>();

  private final List<OrderDTO> orders = new ArrayList<>();

  public ProductServiceImpl() {
    products.addAll(readCsv());
  }

  private List<ProductDTO> readCsv() {

    List<ProductDTO> products = new ArrayList<>();

    try (BufferedReader br =
        new BufferedReader(
            new FileReader("/Users/bagjeong-gyu/workspace/temp/src/main/resources/items_.csv"))) {

      String line;

      br.readLine();

      while ((line = br.readLine()) != null) {

        int notFormatIndex = line.indexOf("\"");

        String[] values = line.split(",");
        if (notFormatIndex > -1) {

          Long id = Long.valueOf(values[0]);

          String name =
              values[1].substring(1, values[1].length())
                  + values[2].substring(0, values[2].length() - 1);

          Integer amount = Integer.valueOf(values[3]);

          Integer count = Integer.valueOf(values[4]);

          products.add(ProductDTO.builder().id(id).name(name).amount(amount).count(count).build());

        } else {

          Long id = Long.valueOf(values[0]);

          String name = values[1];

          Integer amount = Integer.valueOf(values[2]);

          Integer count = Integer.valueOf(values[3]);

          products.add(ProductDTO.builder().id(id).name(name).amount(amount).count(count).build());
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return products;
  }

  @Override
  public void downCount(Long id, Integer orderCount) {

    synchronized (products) {
      ProductDTO product =
          products.stream()
              .filter(val -> Objects.equals(val.getId(), id))
              .findFirst()
              .orElseThrow();

      int downCount = product.getCount() - orderCount;

      if (0 > downCount) {
        throw new SoldOutException();
      }

      orders.add(
          OrderDTO.builder()
              .name(product.getName())
              .count(orderCount)
              .amount(orderCount * product.getAmount())
              .build());

      product.setCount(downCount);
    }
  }

  @Override
  public void print() {

    System.out.println("상품      번호      상품명      판매가격      재고수량");

    for (ProductDTO j : products) {
      System.out.println(j.toString());
    }
  }

  public void print2() {
    System.out.println("---------------------------------");
    String format = "%s - %s개";
    Integer totalAmount = 0;
    for (OrderDTO order : orders) {
      System.out.println(String.format(format, order.getName(), order.getCount()));
      totalAmount += order.getAmount();
    }
    System.out.println("---------------------------------");
    NumberFormat numberFormat = NumberFormat.getInstance();

    int paymentAmount = totalAmount < 50000 ? totalAmount + 2500 : totalAmount;

    System.out.println("주문금액: " + numberFormat.format(totalAmount) + "원");
    System.out.println("지불금액: " + numberFormat.format(paymentAmount) + "원");

    orders.clear();
  }
}
