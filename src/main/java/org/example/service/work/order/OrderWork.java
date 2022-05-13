package org.example.service.work.order;

import org.apache.commons.lang3.StringUtils;
import org.example.dto.OrderDTO;
import org.example.dto.ProductDTO;
import org.example.exception.SoldOutException;
import org.example.service.input.Input;

import java.text.NumberFormat;
import java.util.List;
import java.util.Objects;

public class OrderWork extends AbstractAction {

  public OrderWork(List<ProductDTO> products, List<OrderDTO> orders, Input<String> input) {
    super(products, orders, input);
  }

  @Override
  public void work() {

    print();

    Input<String> input = getInput();

    while (true) {

      String productIdStr = input.getInput("상품 번호: ");

      String countStr = input.getInput("수량: ");

      if (StringUtils.isBlank(productIdStr) || StringUtils.isBlank(countStr)) {
        quit();
        break;
      }

      try {
        down(Long.valueOf(productIdStr), Integer.parseInt(countStr));
      } catch (SoldOutException e) {
        System.out.println(e.getMessage());
        break;
      }
    }
  }

  @Override
  public void print() {
    System.out.println("상품      번호      상품명      판매가격      재고수량");

    for (ProductDTO product : getProducts()) {
      System.out.println(product.toString());
    }
  }

  @Override
  public void quit() {

    System.out.println("---------------------------------");

    String format = "%s - %s개";

    Integer totalAmount = 0;

    List<OrderDTO> orders = getOrders();

    int start = orders.size() - 1;

    for (int i = start; i > -1; i--) {
      OrderDTO order = orders.get(i);
      System.out.printf((format) + "%n", order.getName(), order.getCount());
      totalAmount += order.getAmount();
    }

    System.out.println("---------------------------------");

    NumberFormat numberFormat = NumberFormat.getInstance();

    int paymentAmount = totalAmount < 50000 ? totalAmount + 2500 : totalAmount;

    System.out.println("주문금액: " + numberFormat.format(totalAmount) + "원");
    System.out.println("---------------------------------");

    System.out.println("지불금액: " + numberFormat.format(paymentAmount) + "원");
    System.out.println("---------------------------------");

    System.out.println();
    System.out.println();
    System.out.println();

    orders.clear();
  }

  @Override
  public void down(Long id, Integer orderCount) throws SoldOutException {

    List<ProductDTO> products = getProducts();

    List<OrderDTO> orders = getOrders();

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
}
