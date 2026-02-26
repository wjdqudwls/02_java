package com.beyond.section02.functionalinterface;

import java.util.function.*;

public class Application5 {

  public static void main(String[] args) {

    /* 표준 함수형 인터페이스 중 Predicate를 이해하고 사용할 수 있다.
    * Predicate(단정하다, 단언하다)
    * - 매개 변수를 받아 boolean 값을 반환하는 인터페이스
    * - 매개 변수를 받아 boolean으로 반환하는 testXXX() 메서드를 가지고 있다.
    *
    * */

    /* 1. Predicate<T>#test(T t) : boolean : T를 조사하여 boolean을 리턴한다. */
    Predicate<Object> predicate = value -> value instanceof String;
    System.out.println("Predicate - 문자열인지 확인: " + predicate.test("123"));
    System.out.println("Predicate - 문자열인지 확인: " + predicate.test(123));

    /* 2. BiPredicate<T, U>#test(T t, U u) : boolean : T와 U를 조사하여 true, false를 리턴한다. */
    BiPredicate<String, Integer> biPredicate = (str, length) -> str.length() == length;
    System.out.println("BiPredicate - 문자열 길이 비교: " + biPredicate.test("hello", 5));
    System.out.println("BiPredicate - 문자열 길이 비교: " + biPredicate.test("hello", 3));

    /* 3. DoublePredicate#test(double value) : boolean : double 값을 조사하여 true, false를 리턴한다. */
    DoublePredicate doublePredicate = value -> value > 0.0;
    System.out.println("DoublePredicate - 양수인지 확인: " + doublePredicate.test(10.5));
    System.out.println("DoublePredicate - 양수인지 확인: " + doublePredicate.test(-5.3));

    /* 4. IntPredicate#test(int value) : boolean : int값을 조사하여 true, false를 리턴한다. */
    IntPredicate intPredicate = value -> value % 2 == 0;
    System.out.println("IntPredicate - 짝수인지 확인: " + intPredicate.test(10));
    System.out.println("IntPredicate - 짝수인지 확인: " + intPredicate.test(15));

    /* 5. LongPredicate#test(long value) : boolean : long값을 조사하여 true, false를 리턴한다. */
    LongPredicate longPredicate = value -> value > 1000L;
    System.out.println("LongPredicate - 1000보다 큰지 확인: " + longPredicate.test(5000L));
    System.out.println("LongPredicate - 1000보다 큰지 확인: " + longPredicate.test(500L));
  }

}