package org.example;

import org.apache.commons.lang3.StringUtils;
import org.example.service.ProductService;
import org.example.service.ProductServiceImpl;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    ProductService service = new ProductServiceImpl();

    System.out.print("입력(o[order]: 주문, q[quit]: 종료):");

    String input = scanner.next();

    if ("q".equals(input)) {
      scanner.close();
      return;
    } else if ("o".equals(input)) {

      service.print();

      while (true) {

        System.out.print("상품 번호:");
        String nextLong = scanner.next();

        System.out.print("수량:");
        String nextInt = scanner.next();

        if (StringUtils.isBlank(nextLong) || StringUtils.isBlank(nextInt)) {
          service.print2();
          break;
        }

        service.downCount(Long.valueOf(nextLong), Integer.parseInt(nextInt));
      }
    }

    scanner.close();
  }
}
