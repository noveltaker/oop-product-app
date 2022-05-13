package org.example.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderDTO {

  // 주문 명
  private String name;

  // 주문한 갯수
  private Integer count;

  // 주문가격 ( count * productAmount)
  private Integer amount;
}
