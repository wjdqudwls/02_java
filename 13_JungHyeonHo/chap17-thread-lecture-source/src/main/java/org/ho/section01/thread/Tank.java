package org.ho.section01.thread;

/* Thread를 생성하는 방법
 * 1) Thread 클래스 상속(extends)
 * 2) Runnable 인터페이스 상속(implements)
 * */
public class Tank extends Thread{

  /* Tank 스레드로 수행할 작업을 작성하는 메서드*/
  @Override
  public void run() {
    for(int i=0;i<1000;i++){
      System.out.println("Tank shooting...");

      try {
        Thread.sleep(1); // 현재 스레드(Car)를 1ms간 일시 정지
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

  }
}
