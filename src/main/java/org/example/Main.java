package org.example;

import org.apache.commons.lang3.StringUtils;
import org.example.service.ProductService;
import org.example.service.ProductServiceImpl;
import org.example.service.input.Input;
import org.example.service.input.StringInput;

public class Main {

  public static void main(String[] args) {

    ProductService service = new ProductServiceImpl();

    Input<String> input = new StringInput();

    while (true) {

      String inputStr = input.getInput("test1:");

      if ("q".equals(inputStr)) {
        return;
      } else if ("o".equals(inputStr)) {

        service.print();

        while (true) {

          String nextLong = input.getInput("test2:");

          String nextInt = input.getInput("test3:");

          if (StringUtils.isBlank(nextLong) || StringUtils.isBlank(nextInt)) {
            service.print2();
            break;
          }

          service.downCount(Long.valueOf(nextLong), Integer.parseInt(nextInt));
        }
      }
    }
  }
}
