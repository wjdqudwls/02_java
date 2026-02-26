package org.ho.section01.thread;

public class Application {
  /* java 프로그램 실행 시
   * main thread가 main() 메서드를 호출함
   * */
  public static void main(String[] args) {
    Thread th1 = new Car();
    Thread th2 = new Tank();
    // Thread 생성자 중 Runnable을 매개변수로 받으니, Plane을 넣어 다운캐스팅 시킴
    Thread th3 = new Thread(new Plane());

    /* 스레드 우선 순위 확인 */
    System.out.println("th1 우선 순위 : " + th1.getPriority());
    System.out.println("th2 우선 순위 : " + th2.getPriority());
    System.out.println("th3 우선 순위 : " + th3.getPriority());

    /* 우선 순위 변경*/
    th1.setPriority(Thread.MAX_PRIORITY);
    th2.setPriority(Thread.NORM_PRIORITY);
    th3.setPriority(Thread.MIN_PRIORITY);

    System.out.println("\nth1 우선 순위 : " + th1.getPriority());
    System.out.println("th2 우선 순위 : " + th2.getPriority());
    System.out.println("th3 우선 순위 : " + th3.getPriority());

        /* run() 메서드 호출 == main 스레드에 run() 메서드를 호출하여 실행*/
//    th1.run();
//    th2.run();
      //th1과 th2는 개별스레드로서 순서대로 실행됨

    /* start() 메서드 호출 == 별도 스레드를 생성해서 각각 run() 메서드 호출
     * -> 동시에 실행됨
     * */
    th1.start();
    th2.start();
    th3.start();

    try {
      /* join()
       * - 지정된 스레드(th1,th2,th3)가 끝날 때 까지
       *   현재 스레드를 종료 시키지 않고 대기(일시 정지)
       * */
      th1.join();
      th2.join();
      th3.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("main thread end.....................");
  }
}
