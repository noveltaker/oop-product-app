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

<<<<<<< HEAD
      String inputStr = input.getInput("test1:");

      if ("q".equals(inputStr)) {
        return;
      } else if ("o".equals(inputStr)) {
=======
      String orderAndQuitStr = input.getInput("입력(o[order]: 주문, q[quit]: 종료): ");

      if ("q".equals(orderAndQuitStr)) {
        System.out.println("고객님의 주문 감사합니다.");
        break;
      } else if ("o".equals(orderAndQuitStr)) {
>>>>>>> 3ef7e4d6bcdc05b5cbd6a0176948366e78787f6b

        service.print();

        while (true) {

<<<<<<< HEAD
          String nextLong = input.getInput("test2:");

          String nextInt = input.getInput("test3:");

          if (StringUtils.isBlank(nextLong) || StringUtils.isBlank(nextInt)) {
            service.print2();
            break;
          }

          service.downCount(Long.valueOf(nextLong), Integer.parseInt(nextInt));
=======
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
>>>>>>> 3ef7e4d6bcdc05b5cbd6a0176948366e78787f6b
        }
      }
    }
  }
}
