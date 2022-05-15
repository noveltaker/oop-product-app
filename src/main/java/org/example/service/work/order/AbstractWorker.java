package org.example.service.work.order;

import org.example.dto.OrderDTO;
import org.example.dto.ProductDTO;
import org.example.service.input.Input;
import org.example.service.work.base.AbstractBaseWorker;

import java.util.List;

public abstract class AbstractWorker extends AbstractBaseWorker implements Printer, Quit, Count {
  protected AbstractWorker(List<ProductDTO> products, List<OrderDTO> orders, Input<String> input) {
    super(products, orders, input);
  }
}
