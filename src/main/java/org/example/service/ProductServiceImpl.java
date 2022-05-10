package org.example.service;

import org.example.dto.InputDTO;
import org.example.dto.ItemDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductServiceImpl implements ProductService {

  private final List<ItemDTO> list = new ArrayList<>();

  private final List<InputDTO> inputs = new ArrayList<>();

  public ProductServiceImpl() {
    list.add(ItemDTO.builder().id(1L).name("test1").amount("20000").count(100).build());
  }

  @Override
  public List<ItemDTO> getList() {
    return this.list;
  }

  @Override
  public void downCount(Long id, Integer count) {

    synchronized (list) {
      ItemDTO item =
          list.stream().filter(val -> Objects.equals(val.getId(), id)).findFirst().orElseThrow();

      int downCount = item.getCount() - count;

      if (0 > downCount) {
        System.out.println("break");
        return;
      }

      inputs.add(
          InputDTO.builder()
              .id(item.getId())
              .count(item.getCount())
              .amount(Integer.parseInt(item.getAmount()))
              .build());

      item.setCount(downCount);
    }
  }

  @Override
  public void print() {
    for (ItemDTO j : list) {
      j.print();
    }
  }

  public void print2() {
    for (InputDTO i : inputs) {
      System.out.println(i.toString());
    }
  }
}
