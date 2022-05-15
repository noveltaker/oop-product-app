package org.example.service.work;

import org.example.dto.OrderDTO;
import org.example.dto.ProductDTO;
import org.example.exception.SoldOutException;
import org.example.service.input.Input;
import org.example.service.input.StringInput;
import org.example.service.mock.MultiThread;
import org.example.service.work.order.Count;
import org.example.service.work.order.OrderWork;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderWorkTest {

  private List<ProductDTO> products =
      List.of(ProductDTO.builder().id(1L).amount(1000).count(10).build());

  private List<OrderDTO> orders = new ArrayList<>();

  private Input<String> input = new StringInput();

  private Count count;

  @BeforeEach
  void init() {
    count = new OrderWork(products, orders, input);
  }

  @Test
  @DisplayName("주문 개수 만큼 감소가 되는 케이스")
  void down_success() {

    MultiThread[] threads = new MultiThread[11];

    for (int i = 0; i < 10; i++) {
      threads[i] = new MultiThread(count, 1L, 1);
      threads[i].start();
    }

    Assertions.assertEquals(10, products.get(0).getCount());
  }

  @Test
  @DisplayName("멀티 스레드 환경에서 SoldOutException 이 발생 되는 케이스")
  void down_SoldOutException() {

    for (int i = 0; i < 11; i++) {
      new Thread(
              () -> {
                count.down(1L, 1);
              })
          .start();

      Thread.setDefaultUncaughtExceptionHandler(
          (thread, throwable) ->
              Assertions.assertThrows(SoldOutException.class, throwable::getClass));
    }
  }
}
