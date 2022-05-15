package org.example.service.load.data;

import org.example.dto.ProductDTO;

public class DoubleQuotationData implements Data {

  @Override
  public ProductDTO created(String[] lineArray) {

    Long id = Long.valueOf(lineArray[0]);

    String name =
        lineArray[1].substring(1, lineArray[1].length())
            + lineArray[2].substring(0, lineArray[2].length() - 1);

    Integer amount = Integer.valueOf(lineArray[3]);

    Integer count = Integer.valueOf(lineArray[4]);

    return ProductDTO.builder().id(id).name(name).amount(amount).count(count).build();
  }
}
