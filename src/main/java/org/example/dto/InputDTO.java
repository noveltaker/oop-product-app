package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InputDTO {

  private Long id;

  private Integer count;

  private Integer amount;

  @Override
  public String toString() {
    return id + " " + count + " " + amount;
  }
}
