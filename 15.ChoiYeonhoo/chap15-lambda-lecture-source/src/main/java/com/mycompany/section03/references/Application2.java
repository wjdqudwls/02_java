package com.mycompany.section03.references;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Application2 {
  public static void main(String[] args) {

    /**
     * Step 1: 정적(static) 메서드 참조
     *
     * 형식: 클래스명::정적메서드명
     *
     * 정적 메서드를 참조할 때 사용
     * 람다식의 매개변수가 정적 메서드의 매개변수로 그대로 전달될 때 사용 가능
     */

    System.out.println("=== Step 1: 정적 메서드 참조 ===\n");

    /* 예제 1: 단순 계산 메서드 */
    System.out.println("--- 예제 1: 숫자 계산 ---");

    // 전통적인 방식
    Function<Integer, Integer> traditional = new Function<Integer, Integer>() {
      @Override
      public Integer apply(Integer num) {
        return Calculator.double1(num); // 받은 num을 그대로 Calculator의 double1() 메소드로 전달
      }
    };
    System.out.println("전통적 방식: " + traditional.apply(5));

    // 람다식 방식
    Function<Integer, Integer> lambda = (num) -> Calculator.double1(num);
    System.out.println("람다식 방식: " + lambda.apply(5));

    // 메서드 참조 방식
    Function<Integer, Integer> methodRef = Calculator::double1;
    System.out.println("메서드 참조: " + methodRef.apply(5));

    System.out.println();

    /* 예제 2: 두 개의 매개변수를 받는 메서드 */
    System.out.println("--- 예제 2: 두 숫자의 합 ---");

    // 람다식 방식
    BiFunction<Integer, Integer, Integer> sumLambda = (a, b) -> Calculator.sum(a, b);
    System.out.println("람다식: 10 + 20 = " + sumLambda.apply(10, 20));

    // 메서드 참조 방식
    BiFunction<Integer, Integer, Integer> sumMethodRef = Calculator::sum;
    System.out.println("메서드 참조: 10 + 20 = " + sumMethodRef.apply(10, 20));

    System.out.println();

  }

  /* 계산 유틸리티 클래스 */
  class Calculator {
    // 숫자를 2배로 만드는 정적 메서드
    public static Integer double1(Integer num) {
      return num * 2;
    }

    // 두 숫자의 합을 반환하는 정적 메서드
    public static Integer sum(Integer a, Integer b) {
      return a + b;
    }
  }

  /* 문자열 처리 유틸리티 클래스 */
  class StringProcessor {
    // 문자열을 대문자로 변환하는 정적 메서드
    public static String toUpperCase(String str) {
      return str.toUpperCase();
    }
  }


}
