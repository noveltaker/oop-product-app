package org.example.service.work.order;

import org.example.dto.OrderDTO;
import org.example.dto.ProductDTO;
import org.example.service.input.Input;
import org.example.service.work.main.AbstractWork;

import java.util.List;

public abstract class AbstractAction extends AbstractWork implements Printer, Quit, Count {
  protected AbstractAction(List<ProductDTO> products, List<OrderDTO> orders, Input<String> input) {
    super(products, orders, input);
  }
}
