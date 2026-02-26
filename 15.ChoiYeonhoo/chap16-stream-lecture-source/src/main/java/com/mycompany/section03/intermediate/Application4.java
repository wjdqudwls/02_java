package com.mycompany.section03.intermediate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application4 {
  public static void main(String[] args) {

    /* 스트림 중간 연산 : sorted()
    * - 정렬된 스트림을 만들어서 반환하는 메서드
    * */
    List<Integer> integerList =
        IntStream.of(5, 10, 99, 2, 1, 35)
            .boxed() // int -> Integer
//            .sorted() // 기본 정렬
//            .sorted((a,b)-> a - b) // 추가 정렬 방식 : 오름차순 정렬
            .sorted((a,b)-> b - a) // 추가 정렬 방식 : 내림차순 정렬
//            .collect(Collectors.toList());
            .toList();

    System.out.println(integerList);

    /* skip.(), limit() */
    IntStream intStream2 = IntStream.range(1,10); // 1 ~ 9
    intStream2
        .skip(2) // 두개 건너 뛰기
        .limit(5).forEach(System.out::println); // 3,4,5,6,7



  }

}
