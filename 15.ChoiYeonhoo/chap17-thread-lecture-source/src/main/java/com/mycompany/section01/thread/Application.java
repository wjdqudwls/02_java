package com.mycompany.section01.thread;

public class Application {

  /* java 프로그램 실행 시,
  * main thread가 main() 메서드를 호출함
  * */
  public static void main(String[] args) {
    Thread th1 = new Car();
    Thread th2 = new Tank();
    Thread th3 = new Thread(new Plane()); // Runnable 상속 스레드 생성 방법

    /* 스레드 우선 순위 확인 -> 기본 우선 순위 == 5 */
    System.out.println("th1 우선 순위 " + th1.getPriority());
    System.out.println("th2 우선 순위 " + th2.getPriority());
    System.out.println("th3 우선 순위 " + th3.getPriority());

    /* 우선 순위 변경 */
    th1.setPriority(Thread.MAX_PRIORITY); //10
    th2.setPriority(Thread.NORM_PRIORITY); // 5
    th3.setPriority(Thread.MIN_PRIORITY); // 1

    System.out.println("th1 우선 순위 " + th1.getPriority());
    System.out.println("th2 우선 순위 " + th2.getPriority());
    System.out.println("th3 우선 순위 " + th3.getPriority());

    /* run() 메서드 호출 == main 스레드에 run() 메서드를 호출하여 실행
    * -> 순서대로 실행 됨
    * */
//    th1.run();
//    th2.run();

    /* start() 메서드 호출 == 별보 스레드를 생성해서 각각 run()호출
    * -> 동시에 실행 됨*/
    th1.start();
    th2.start();
    th3.start();

    try {
      /* join()
      * - 지정된 스레드, th1,th2,th3가 끝날때 까지
      *   현재 스레드를 종료 시키지 않고 대기(일시 정지)
      * */
      th1.join();
      th2.join();
      th3.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println("main thread end..............");

  }
}
