package org.example.service.load.data;

import org.example.dto.ProductDTO;

public class CommaData implements Data {

  @Override
  public ProductDTO created(String[] lineArray) {
    Long id = Long.valueOf(lineArray[0]);

    String name = lineArray[1];

    Integer amount = Integer.valueOf(lineArray[2]);

    Integer count = Integer.valueOf(lineArray[3]);

    return ProductDTO.builder().id(id).name(name).amount(amount).count(count).build();
  }
}
