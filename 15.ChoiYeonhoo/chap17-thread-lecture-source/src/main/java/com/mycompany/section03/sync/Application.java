package com.mycompany.section03.sync;

public class Application {
  public static void main(String[] args) {

    /* 공유 인스턴스(자원) 버퍼 생성 */
    Buffer buffer = new Buffer();

    /* 동일한 버퍼 인스턴스를 공유하는 두개의 스레드 생성 */
    Thread p = new Producer(buffer);
    Thread c = new Consumer(buffer);

    p.start();
    c.start();


  }
}
