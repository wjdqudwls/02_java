package com.kth.level01.basic;

public class Application {
  public static void main(String[] args) {

    Calculator calculator = new Calculator();
    System.out.println("메서드 호출 확인");

    int sumResult = calculator.sum1to10();
    System.out.println("1부터 10까지의 합 : " + sumResult);

    int maxResult = calculator.checkMaxNumber(10, 20);
    System.out.println("두 수 중 큰 수는 " + maxResult + "이다." );

    int sumTwoResult = calculator.sumTwoNumbers(10, 20);
    System.out.println("10과 20의 합은 : " + sumTwoResult);

    int minusTwoResult = calculator.minusTwoNumbers(10, 5);
    System.out.println("10과 5의 차는 : " + minusTwoResult);
  }

}