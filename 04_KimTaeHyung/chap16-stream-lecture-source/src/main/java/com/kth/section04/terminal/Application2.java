package com.kth.section04.terminal;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application2 {
  public static void main(String[] args) {

    // 인자가 1개일 경우
    /* 이전 연산에서 반환된 결과를 다음 연산의 첫 번째 인자로 전달 */
    OptionalInt reduceOneParam = IntStream.range(1, 10)     // 1, 2, 3
        .reduce((a, b) -> {
          System.out.println("a : " + a + ", b: " + b);
          return Integer.sum(a, b);
        });

    System.out.println("reduceOneParam = " + reduceOneParam.getAsInt());

    // 인자가 2개일 경우
    // 첫 번째 인자를 초기 값으로 사용
    int reduceTwoParam = IntStream.range(1, 4)      // 1, 2, 3
        .reduce(100, Integer::sum);

    System.out.println("reduceTwoParam = " + reduceTwoParam);

    // 인자가 3개일 경우
    // 3번째 인자 == 병렬 스트림의 처리 결과를 합치는 용도(Combiner, 결합기)
    Integer reduceThreeParam = Stream.of(1, 2, 3, 4, 5, 6 ,7 ,8 ,9 ,10)
        .reduce(100,
            Integer::sum,
            (x, y) -> x + y
        );

    System.out.println("reduceThreeParam = " + reduceThreeParam);

  }
}
