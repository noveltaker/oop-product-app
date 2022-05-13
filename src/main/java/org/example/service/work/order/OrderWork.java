package org.example.service.work.order;

import org.apache.commons.lang3.StringUtils;
import org.example.dto.OrderDTO;
import org.example.dto.ProductDTO;
import org.example.exception.SoldOutException;
import org.example.service.input.Input;

import java.util.List;

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
}
