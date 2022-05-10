package org.example.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ItemDTO {

  private Long id;

  private String name;

  private String amount;

  private Integer count;

  public void print() {
    String print =
        Thread.currentThread().getName() + " " + id + " " + name + " " + amount + " " + count;
    System.out.println(print);
  }

  public void setCount(Integer count) {
    this.count = count;
  }
}
