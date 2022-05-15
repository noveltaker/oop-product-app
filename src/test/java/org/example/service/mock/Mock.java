package org.example.service.mock;

import org.example.dto.OrderDTO;
import org.example.dto.ProductDTO;
import org.example.service.input.Input;
import org.example.service.input.StringInput;

import java.util.ArrayList;
import java.util.List;

public class Mock {

  public static final List<ProductDTO> products =
      List.of(ProductDTO.builder().id(1L).amount(1000).count(10).build());

  public static final List<OrderDTO> orders = new ArrayList<>();

  public static final Input<String> input = new StringInput();
}
