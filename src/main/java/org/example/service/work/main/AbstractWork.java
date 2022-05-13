package org.example.service.work.main;

import org.example.dto.OrderDTO;
import org.example.dto.ProductDTO;
import org.example.service.input.Input;
import org.example.service.work.Work;

import java.util.List;

public abstract class AbstractWork implements Work {

  private final List<ProductDTO> products;

  private final List<OrderDTO> orders;

  private final Input<String> input;

  protected AbstractWork(List<ProductDTO> products, List<OrderDTO> orders, Input<String> input) {
    this.products = products;
    this.orders = orders;
    this.input = input;
  }

  protected final List<OrderDTO> getOrders() {
    return orders;
  }

  protected final List<ProductDTO> getProducts() {
    return products;
  }

  protected final Input<String> getInput() {
    return input;
  }
}
