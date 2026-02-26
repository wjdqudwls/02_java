package org.ho.section04.terminal;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Application1 {
  /* 스트림 최종 연산
  - 가공된 스트림을 이용해서 결과를 반환 하는 메서드

  calculating 최종 연산 : sum(), max(), min(), count(), average()
   */
  public static void main(String[] args) {

    long count = IntStream.range(1, 10).count();
    long sum = IntStream.range(1, 10).sum();

    System.out.println("IntStream = " + Arrays.toString(IntStream.range(1,10).toArray()));
    System.out.println("count() = " + count);
    System.out.println("sum() = " + sum);

    OptionalInt max = IntStream.range(1, 10).max();
    OptionalInt min = IntStream.range(1, 10).min();
    System.out.println("max() = " + max.getAsInt());
    System.out.println("min() = " + min.getAsInt());

    OptionalDouble average = IntStream.range(1,10).average();
    System.out.println("average() = " + average.getAsDouble());

    int OddSum = IntStream.range(1, 10) // 1~9
        .filter(i -> i % 2 == 1) // 1,3,5,7,9
        .sum(); // 1,3,5,7,9 합
    System.out.println("OddSum = " + OddSum);
  }
}
