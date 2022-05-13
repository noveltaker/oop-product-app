package org.example.service.mock;

import org.example.exception.SoldOutException;
import org.example.service.work.order.Count;

public class MultiThread extends Thread {
  private final Count count;

  private final Long id;

  private final Integer orderCount;

  public MultiThread(Count count, Long id, Integer orderCount) {
    this.count = count;
    this.id = id;
    this.orderCount = orderCount;
  }

  public void run() throws SoldOutException {
    count.down(id, orderCount);
  }
}
