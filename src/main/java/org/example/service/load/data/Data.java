package org.example.service.load.data;

import org.example.dto.ProductDTO;

public interface Data {

  ProductDTO created(String[] lineArray);
}
