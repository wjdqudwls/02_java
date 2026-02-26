package com.beyond.section01.thread;

public class Plane implements Runnable {
  @Override
  public void run() {
    for (int i = 0; i < 1000; i++) {
      System.out.println("Plane flight...");

      try {
        Thread.sleep(5);
      } catch (InterruptedException e)  {
        throw new RuntimeException();
      }
    }
  }
}
