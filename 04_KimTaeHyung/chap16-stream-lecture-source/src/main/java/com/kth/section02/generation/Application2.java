package com.kth.section02.generation;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Application2 {
  public static void main(String[] args) {

    /* 기본 자료형 스트림 생성하기 */
    IntStream intStream = IntStream.range(5, 10); // 5이상 10미만 정수 스트림 생성
    intStream.forEach(i -> System.out.print(i + " "));
    System.out.println();

    LongStream longStream = LongStream.rangeClosed(5, 10); // 5이상 10이하 long 스트림 생성
    longStream.forEach(i -> System.out.print(i + " "));
    System.out.println();

    /* Wrapper 클래스 자료형의 스트림이 필요한 경우 boxing 관련 메서드 사용*/
    Stream<Double> boxedDoubleStream = new Random().doubles(5).boxed();
    boxedDoubleStream.forEach(i -> System.out.print(i + " "));
    System.out.println();


    /* 문자열을 IntStream으로 변환 */
    IntStream intStream2 = "Hello Stream World".chars();
    intStream2.forEach(ch -> System.out.print((char)ch + " "));
    System.out.println();


    /* 스트림 합치기 */

    // Stream.of(...values) : values 값이 저장된 스트림 생성
    Stream<String> stringStream1 = Stream.of("Hello", "Stream", "World");
    Stream<String> stringStream2 = Stream.of("Java", "Spring", "SpringBoot");

    // 스트림 합치기
    Stream<String> concatStream = Stream.concat(stringStream1, stringStream2);
    concatStream.forEach(s -> System.out.print(s + " "));

  }
}
