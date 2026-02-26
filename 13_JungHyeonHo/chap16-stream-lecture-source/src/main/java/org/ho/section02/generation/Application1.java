package org.ho.section02.generation;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Application1 {
  public static void main(String[] args) {
    /* 배열, 컬렉션을 이용한 스트림 생성 방법 */

    /* 1. 배열로 스트림 생성하기 */
    String[] strArr = new String[]{"hello", "stream", "world"};

    Stream<String> strStream = Arrays.stream(strArr);

    //strStream.forEach(s -> System.out.println(s));
    strStream.forEach(System.out::println);


    /* 2. 컬렉션으로 스트림 생성하기 */
    List<String> stringList = Arrays.asList("hello", "stream", "world");
    Stream<String> strStream2 = stringList.stream();
    strStream2.forEach(new Consumer<String>(){ // 익명 내부 클래스
      @Override
      public void accept(String s) {
        System.out.println(s);
      }
    });
//    strStream2.forEach((String str)->{System.out.println(str);}); // 람다 함수
//    strStream2.forEach(str-> System.out.println(str)); // 람다 함수(축약형)
//    strStream2.forEach(System.out::println); // Consumer.accept를 오버라이딩 = println

    /* 3. Builder를 이용하여 스트림 생성하기 */
    Stream<String> strStream3 =
        Stream.<String>builder() //의미 : builder로 원본 없이 스트림으로 바로 조회할 데이터 생성
            .add("java")
            .add("mariadb")
            .add("spring")
            .add("vue3")
            .build();
    // stream은 1회용이다. stream has already been operated upon or closed
//    strStream3.forEach(System.out::println); // => 메서드 참조로는 sout와 toUpperCase를 동시에 사용 못한다.
    strStream3.forEach(str -> System.out.println(str.toUpperCase()));

  }
}
