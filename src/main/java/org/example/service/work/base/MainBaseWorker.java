package org.example.service.work.base;

import org.example.dto.OrderDTO;
import org.example.dto.ProductDTO;
import org.example.enums.WorkState;
import org.example.service.input.Input;
import org.example.service.work.order.OrderWorker;
import org.example.service.work.quit.QuitWorker;

import java.util.List;

public final class MainBaseWorker extends AbstractBaseWorker {

  public MainBaseWorker(List<ProductDTO> products, List<OrderDTO> orders, Input<String> input) {
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
          worker = new QuitWorker();
          worker.work();
          isActionAble = Boolean.FALSE;
          break;
        case ORDER:
          worker = new OrderWorker(getProducts(), getOrders(), getInput());
          worker.work();
          break;
        default:
          break;
      }
    }
  }

  private WorkState convertOf(String inputString) {
    if ("q".equals(inputString) || "quit".equals(inputString)) {
      return WorkState.QUIT;
    } else if ("o".equals(inputString) || "order".equals(inputString)) {
      return WorkState.ORDER;
    }
    return WorkState.NONE;
  }
}
