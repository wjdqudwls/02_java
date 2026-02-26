package com.beyond.section03.intermediate;

import java.util.stream.IntStream;

public class Application1 {
  public static void main(String[] args) {
    /* 스트림 중간 연산
     * - 원본 스트림을 이용해 새로운 스트림을 만드는 연산(메서드)
     * */

    /* filter(Predicate)
     * - 스트림 데이터 중 Predicate 메서드 결과가 true인 데이터만 가지고
     *   새로운 스트림을 만드는 메서드
     * */

    IntStream intStream = IntStream.rangeClosed(1,10); // 1 - 10
    intStream.filter(i -> i % 2 == 0).forEach(System.out::println);


  }
}
