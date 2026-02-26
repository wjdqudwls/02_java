package com.mycompany.section04.terminal;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Application1 {
  public static void main(String[] args) {

    /* 스트림 최종 연산
    * - 가공된 스트림을 이용해서 결과를 반환 하는 메서드
    *
    * calculating 최종 연산 : sum(), max(), min(), count(), average()
    * */

    long count = IntStream.range(1, 10).count();
    long sum = IntStream.range(1, 10).sum();
    OptionalDouble optionalDouble = IntStream.range(1, 10).average();
    double avg = optionalDouble.getAsDouble(); // Optical : null 처리 위한 옵션이 있는 타입
    System.out.println("avg = " + avg);

    System.out.println("count = " + count);
    System.out.println("sum = " + sum);

    OptionalInt max = IntStream.range(1, 10).max();
    OptionalInt min = IntStream.range(1, 10).min();

    System.out.println("max = " + max.getAsInt());
    System.out.println("min = " + min.getAsInt());

    int OddSum = IntStream.range(1, 10) // 1,2,3,4,5,6,7,8,9
        .filter(i -> i % 2 == 1) // 1,3,5,7,9
        .sum(); // 25

    System.out.println("OddSum = " + OddSum);

  }
}
