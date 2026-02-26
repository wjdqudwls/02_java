package com.mycompany.section01.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Application1 {
  public static void main(String[] args) {

    List<String> list = new ArrayList<>(Arrays.asList("hello", "stream", "world"));

    /* list 내에서 "stream"만 출력하기 */
    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()) {// .hasNext() : 다음 요소가 있으면 true, 없으면 false
      String element = iterator.next(); // .next() : 다음 요소를 꺼내 대입

      if ("stream".equals(element)) {
        System.out.println("걸러낸 값 : " + element);
      }
    }
    /* 위, 동작을 스트림을 이용해서 수행
    * - 이어쓰면 보기 힘들어서 한줄씩 */
    list
        .stream()
//        .filter(element -> "stream".equals(element))
        .filter("stream"::equals)
//        .forEach(str-> System.out.println("필러팅된 값 = " + str));
        .forEach(System.out::println);
  }
}
