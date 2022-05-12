package org.example.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDTO {

  // 번호
  private Long id;

  // 명
  private String name;

  // 가격
  private Integer amount;

  // 수량
  @Setter private Integer count;

  @Override
  public String toString() {
    return String.format("%s     %s     %s     %s", id, name, amount, count);
  }
}
