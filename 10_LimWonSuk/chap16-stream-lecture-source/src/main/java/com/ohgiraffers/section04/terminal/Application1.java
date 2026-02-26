package com.ohgiraffers.section04.terminal;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Application1 {
    public static void main(String[] args) {
        /*스트림 최종 연산
        * - 가공된 스트림을 이용해서 결과를 반환 하는 메서드
        *
        * calculating 최종연산 : su,(), max(), min(), count(), average()*/

        // int count = IntStream.range(1, 10).count();
        long count = IntStream.range(1, 10).count();
       // int sum = IntStream.range(1, 10).sum();
        long sum = IntStream.range(1, 10).sum();
        System.out.println("count = " + count); // 9
        System.out.println("sum = " + sum); // 45

        OptionalDouble od = IntStream.range(1, 10).average();
        double avg = od.getAsDouble();
        System.out.println("avg = " + avg);


        OptionalInt max = IntStream.range(1, 10).max();
        OptionalInt min = IntStream.range(1, 10).min();
      //  System.out.println("min = " + min); // 1
      //  System.out.println("max = " + max); // 9
        System.out.println("min = " + min.getAsInt());
        System.out.println("max = " + max.getAsInt());



        int OddSum = IntStream.range(1, 10)
                .filter(i -> i % 2 == 1)
                .sum();
        System.out.println("OddSum = " + OddSum);
    }
}
