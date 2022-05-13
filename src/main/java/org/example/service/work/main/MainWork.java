package org.example.service.work.main;

import org.example.dto.OrderDTO;
import org.example.dto.ProductDTO;
import org.example.enums.WorkState;
import org.example.service.input.Input;
import org.example.service.work.Work;
import org.example.service.work.order.OrderWork;
import org.example.service.work.quit.QuitWork;

import java.util.List;

public final class MainWork extends AbstractWork {

  public MainWork(List<ProductDTO> products, List<OrderDTO> orders, Input<String> input) {
    super(products, orders, input);
  }

  @Override
  public void work() {

    boolean isActionAble = Boolean.TRUE;

    while (isActionAble) {

      String inputString = getInput().getInput("입력(o[order]: 주문, q[quit]: 종료): ");

      WorkState state = convertOf(inputString);

      Work worker;

      switch (state) {
        case QUIT:
          worker = new QuitWork();
          worker.work();
          isActionAble = Boolean.FALSE;
          break;
        case ORDER:
          worker = new OrderWork(getProducts(), getOrders(), getInput());
          worker.work();
          break;
        default:
          break;
      }
    }
  }

  private WorkState convertOf(String inputString) {
    if ("q".equals(inputString)) {
      return WorkState.QUIT;
    } else if ("o".equals(inputString)) {
      return WorkState.ORDER;
    }
    return WorkState.NONE;
  }
}
