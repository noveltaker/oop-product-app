package org.example.service;

import org.example.dto.ItemDTO;

import java.util.List;

public interface ProductService {

  List<ItemDTO> getList();

  void downCount(Long id, Integer count);

  void print();

  void print2();
}
