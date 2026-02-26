package com.kth.section03.intermediate;

import java.util.List;
import java.util.stream.IntStream;

public class Application4 {
  public static void main(String[] args) {

    /* 스트림 중간 연산 : sorted()
    * - 정렬된 스트림을 만들어서 반환하는 메서드
    * */

    List<Integer> integerList =
        IntStream.of(5, 10, 99, 22, 1, 35)
            .boxed() // int -> Integer
            //.sorted()
            .sorted((a, b) -> b - a) // 추가 정렬 방식
            .toList(); // .collect(Collectors.toList());

    System.out.println(integerList);


    /* skip(), limit() */
    IntStream intStream2 = IntStream.range(1,10);
    intStream2.skip(2).limit(5).forEach(System.out::println);


  }
}
