package com.kth.level01.basic;

public class Calculator {

  public void checkMethod(){
    System.out.println("메소드 호출 확인");
  }

  public int sum1to10(){
    int sum = 0;
    for (int i = 1; i <=10 ; i++) {
      sum += i;
    }
    return sum;
  }

  /**
   * 두 수를 입력받아 큰 수를 반환하는 메소드
   * @param a 첫 번째 정수
   * @param b 두 번째 정수
   */
  public int checkMaxNumber(int a, int b){
    return Math.max(a, b);
  }

  /**
   * 두 수를 입력받아 합을 반환하는 메소드
   * @param a 첫 번째 정수
   * @param b 두 번째 정수
   * @return 두 수의 합
   */
  public int sumTwoNumbers(int a, int b){
    return a + b;
  }

  /**
   * 두 수를 입력받아 차를 반환하는 메소드
   * @param a 첫 번째 정수
   * @param b 두 번째 정수
   * @return 두 수의 차
   */
  public int minusTwoNumbers(int a, int b){
    return a - b;
  }

}
