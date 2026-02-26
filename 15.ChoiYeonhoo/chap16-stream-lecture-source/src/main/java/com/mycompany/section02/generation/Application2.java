package com.mycompany.section02.generation;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Application2 {
  public static void main(String[] args) {

    /* 기본 자료형 스트림 생성하기 */

    IntStream intStream = IntStream.range(5,10); // 5 <= x < 10  까지 범위의 IntStream 생성
    intStream.forEach(i -> System.out.print(i + " ") );
    System.out.println();

    LongStream longStream = LongStream.rangeClosed(5,10); // 5 <= x <= 10  까지 범위의 LongStream 생성
    longStream.forEach(i -> System.out.print(i + " ") );
    System.out.println();

    /* Wrapper 클래스 자료형의 스트림이 필요한 경우 boxing 관련 메서드 사용*/
    Stream<Double> boxedDoubleStream = new Random().doubles(5).boxed(); // Stream을 만들땐 Auto boxing이 안되서 double -> Double로 수동으로 boxing 해줌
    boxedDoubleStream.forEach(System.out::println);
    System.out.println();

    /* 문자열을 IntStream으로 변환*/
    IntStream intStream2 = "Hello Stream World".chars();
    intStream2.forEach(ch -> System.out.print((char)ch + " "));
    System.out.println();

    /* 스트림 합치기 */
    // .of로 만들면 수정 불가능한 읽기 전용이 만들어짐(add가 안됨) Stream 말고도, List, Map 등에도 마찬가지

    // Stream.of (... values) : values 값이 저장된 스트림 생성
    Stream<String> stringStream1 = Stream.of("Hello", "Stream", "World");
    Stream<String> stringStream2 = Stream.of("Java", "Spring", "SpringBoot");

    // 스트림 합치기
    Stream<String> concatStream = Stream.concat(stringStream1, stringStream2);
    concatStream.forEach(str -> System.out.print(str + " "));
    System.out.println();



  }
}
