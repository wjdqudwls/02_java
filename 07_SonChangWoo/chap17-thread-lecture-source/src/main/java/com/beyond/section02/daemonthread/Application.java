package com.beyond.section02.daemonthread;

import java.util.Scanner;

public class Application {
  public static void main(String[] args) {

    /* 데몬 스레드
    * - 백그라운드에서 보조 역할을 수행하는 스레드
    * - 다른 일반 스레드들이 모두 종료되면 같이 종료된다.
    * */

    Thread thread = new Thread(() -> {
      for (int i = 20; i > 0; i--) {
        System.out.println(i);
      }
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      });

    /* setDaemon(true) : 지정된 스레드를 데몬 스레드로 설정
    * 반드시 start() 전에 설정해야 한다.
    * */

    thread.setDaemon(true);

    thread.start();

    /* main 스레드의 동작 */
    Scanner sc = new Scanner(System.in);
    System.out.print("카운트를 멈추려면 아무 키나 입력하세요 : ");
    String input = sc.nextLine();
    System.out.println("input = " + input);
    System.out.println("===== 카운트 종료 =====");
    thread.interrupt();

  }
}
