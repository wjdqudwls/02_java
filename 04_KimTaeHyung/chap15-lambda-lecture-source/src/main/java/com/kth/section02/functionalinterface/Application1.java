package com.kth.section02.functionalinterface;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.function.*;

/* 람다식 생략 규칙
* 1) {} 내부 코드가 한 줄인 경우 {} 생략 가능
*  단, 한 줄인 코드가 return 구문이면 return도 생략 가능
*
* 2) () 내부 매개 변수가 한 개이면 () 생략 가능
* */

public class Application1 {
  public static void main(String[] args) {
    /* 표준 함수형 인터페이스 중 Consumer를 이해하고 사용할 수 있다.
    *
    * Consumer(소비자)
    * - 매개 변수로 값을 전달 받아 소비하는 함수형 인터페이스
    * - 리턴 값이 없는 accept() 메서드를 가지고 있다.
    * */

    /* 1. Consumer<T>#accept(T t):void  : 객체 T를 받아 소비한다. */
    Consumer<String> consumer
        = (str) -> System.out.println(str + "이/가 입력됨");

    consumer.accept("Hello World");

    /* 2. BiConsumer<T, U>#accept(T t, U u) : void : 객체 T, U를 받아 소비한다. */
    BiConsumer<String, LocalTime> biConsumer
        = (str, time) -> System.out.println(str + "이/가" + time + "에 입력됨.");

    biConsumer.accept("hello", LocalTime.now());

    /* 3. IntConsumer#accept(int value) : void : int값을 받아 소비한다. */
    IntConsumer intConsumer = num -> System.out.println("입력하신 정수의 제곱은 " + (num * num) + "입니다.");
    intConsumer.accept(15);

    /* 4. DoubleConsumer#accept(double value) : void : double값을 받아 소비한다. */
    DoubleConsumer doubleConsumer = num -> System.out.println("입력하신 실수의 제곱근은 " + Math.sqrt(num) + "입니다.");
    doubleConsumer.accept(123.45);

    /* 5. LongConsumer#accept(long value) : void : long값을 받아 소비한다. */
    LongConsumer longConsumer = num -> System.out.println("입력하신 정수는 " + num + "입니다.");
    longConsumer.accept(12345);

    /* 6. ObjIntConsumer<T>#accept(T t, int value) : void : 객체 T와 int값을 받아 소비한다. */
    ObjIntConsumer<Random> objIntConsumer =
        (random, bound) -> System.out.println("0 부터 " + bound + "전 까지의 난수 발생 : " + random.nextInt(bound));
    objIntConsumer.accept(new java.util.Random(), 10);

    /* 7. ObjLongConsumer<T>#accept(T t, long value) : void : 객체 T와 long값을 받아 소비한다. */
    ObjLongConsumer<LocalDate> objLongConsumer =
        (date, days) -> System.out.println(date + "의 " + days + "일 후의 날짜는 : " + date.plusDays(days));
    objLongConsumer.accept(LocalDate.now(), 10);

    /* 8. ObjDoubleConsumer<T>#accept(T t, double value) : void : 객체 T와 double값을 받아 소비한다. */
    ObjDoubleConsumer<StringBuilder> objDoubleConsumer =
        (sb, doubleValue) -> System.out.println(sb.append(Math.abs(doubleValue)));
    objDoubleConsumer.accept(new StringBuilder("절대값 : "), -123.5);

  }
}
