package com.mycompany.section01.thread;

public class Plane implements Runnable {
  @Override
  public void run() {
    for (int i = 0; i < 1000; i++) {
      System.out.println("Plane Flying...");

      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

    }
  }
}
