package org.example.service.work.order;

import java.text.NumberFormat;

public interface Printer {
  void print();

  default void printTotalAmount(String comment, Integer totalAmount) {

    NumberFormat numberFormat = NumberFormat.getInstance();

    System.out.println(comment + numberFormat.format(totalAmount) + "원");
    System.out.println("---------------------------------");
  }
}
