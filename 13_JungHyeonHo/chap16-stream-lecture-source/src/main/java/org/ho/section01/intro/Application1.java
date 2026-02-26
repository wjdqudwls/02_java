package org.ho.section01.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Application1 {
  public static void main(String[] args) {
    List<String> list
        = new ArrayList<>(Arrays.asList("hello", "stream", "world", "stream"));

    /* list 내에서 "stream"만 출력하기 */
    // 1. while문, Iterator 등 많은게 쓰임
    System.out.println("1. while문, Iterator 등 많은게 쓰임");
    Iterator<String> it = list.iterator();  // 내부 반복자
    while (it.hasNext()) {  // 다음 요소가 있으면 true, 없으면 false
      String e = it.next(); // 다음 요소를 꺼내 element 대입
      if ("stream".equals(e)) {
        System.out.println("걸러낸 값 : " + e);
      }
    }
    // 총 7줄이나 썼다

    // 2. Stream()을 이용해서 수행
    System.out.println("2. Stream()을 이용해서 수행");
    list.stream() //a. list를 내부반복자로 조회하는 형태로 바꿈
            //Stream<T> filter(Predicate<? super T> predicate); => T는 String
        .filter("stream"::equals) // 메서드 참조로 구현
        .forEach(str -> System.out.println("필터링된 값 : " + str)); //filter 걸러진 것들 출력
  }
}
