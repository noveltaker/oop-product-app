package org.example;

import org.apache.commons.lang3.StringUtils;
import org.example.exception.SoldOutException;
import org.example.service.ProductService;
import org.example.service.ProductServiceImpl;
import org.example.service.input.Input;
import org.example.service.input.StringInput;

public class Main {

  public static void main(String[] args) {

    ProductService service = new ProductServiceImpl();

    Input<String> input = new StringInput();

    while (true) {

      String orderAndQuitStr = input.getInput("입력(o[order]: 주문, q[quit]: 종료): ");

      if ("q".equals(orderAndQuitStr)) {
        System.out.println("고객님의 주문 감사합니다.");
        break;
      } else if ("o".equals(orderAndQuitStr)) {

        service.print();

        while (true) {

          String productIdStr = input.getInput("상품 번호: ");

          String countStr = input.getInput("수량: ");

          if (StringUtils.isBlank(productIdStr) || StringUtils.isBlank(countStr)) {
            service.print2();
            break;
          }
          try {
            service.downCount(Long.valueOf(productIdStr), Integer.parseInt(countStr));
          } catch (SoldOutException e) {
            System.out.println(e.getMessage());
            break;
          }
        }
      }
    }
  }
}
