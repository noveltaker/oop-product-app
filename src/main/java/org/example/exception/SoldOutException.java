package org.example.exception;

public class SoldOutException extends RuntimeException {
  private final String message = "SoldOutException 발생. 주문한 상품이 제고량 보다 많습니다.";

  @Override
  public String getMessage() {
    return message;
  }
}
