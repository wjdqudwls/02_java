package org.ho.section02.generation;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Application2 {
  public static void main(String[] args) {

    /* 기본 자료형 스트림 생성하기 */
    System.out.println("1.intStream");
    IntStream intStream = IntStream.range(5,10); // 5이상 10 미만 정수 스트림
    intStream.forEach(i -> System.out.print(i+" "));

    System.out.println("\n2.longStream");
    LongStream longStream = LongStream.rangeClosed(5,10); // Closed를 붙이면 10 이하로, Long 스트림
    longStream.forEach(i -> System.out.print(i+" "));

    /* Wrapper 클래스 자료형의 스트림이 필요한 경우 boxing 관련 메서드 사용*/
    Stream<Double> boxedDoubleStream =
        new Random().doubles(5) // double 타입 데이터 5개를 만든다
            .boxed(); // <> 안에는 랩퍼클래스이므로 boxing해준다.(double to Double)
                            // => 스트림은 Auto-Boxing 안됨
    System.out.println("\n3.DoubleStream");
    boxedDoubleStream.forEach(d -> System.out.print(d+" "));

    /* 문자열을 IntStream으로 변환 */
    IntStream intStream2 = "Hello Stream World".chars();
    System.out.println("\n4.IntStream => char[] 출력");
    intStream2.forEach(i -> System.out.print((char)i));
    System.out.println();

    /* 스트림 합치기 */
    Stream<String> stringStream1
        //of는 위의 builder같이 무언갈 만들때 사용된다
        //차이점으로는 읽기전용이다. 수정 추가 삭제 등이 안된다. 근데 어차피 Stream은 읽기전용 ㅎ
        = Stream.of("Hello", "Stream", "World");
    Stream<String> stringStream2 = Stream.of("Java", "Spring", "SpringBoot");

      //stream 2개를 합쳐서 출력한다
    Stream<String> concatStream = Stream.concat(stringStream1, stringStream2);

    concatStream.forEach(s -> System.out.print(s + " "));
  }
}
