package org.example.service.work.quit;

import org.example.service.work.base.Work;

public class QuitWorker implements Work {

  @Override
  public void work() {
    System.out.println("고객님의 주문 감사합니다.");
  }
}
