package org.example.service.work;

import org.example.enums.WorkState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainBaseWorkTest {

  @BeforeEach
  void init() {}

  @Test
  @DisplayName("quit state 테스트 케이스")
  void convertOf_quit() {

    String inputString = "q";

    WorkState defaultState = WorkState.NONE;

    if ("q".equals(inputString) || "quit".equals(inputString)) {
      defaultState = WorkState.QUIT;
    } else if ("o".equals(inputString) || "order".equals(inputString)) {
      defaultState = WorkState.ORDER;
    }

    Assertions.assertEquals(defaultState, WorkState.QUIT);
  }

  @Test
  @DisplayName("order state 테스트 케이스")
  void convertOf_order() {

    String inputString = "o";

    WorkState defaultState = WorkState.NONE;

    if ("q".equals(inputString) || "quit".equals(inputString)) {
      defaultState = WorkState.QUIT;
    } else if ("o".equals(inputString) || "order".equals(inputString)) {
      defaultState = WorkState.ORDER;
    }

    Assertions.assertEquals(defaultState, WorkState.ORDER);
  }
}
