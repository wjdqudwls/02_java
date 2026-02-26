package com.beyond.section01.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Application1 {
  public static void main(String[] args) {

    List<String> list = new ArrayList<>(Arrays.asList("hello","stream","world"));

    System.out.println("list = " + list);

    /* list 내에서 "stream"만 출력하기 */
    Iterator<String> iterator = list.iterator(); // 반복자

    while (iterator.hasNext()) { // 다음 요소가 있으면 true, 없음 false
      String element = iterator.next(); // 다음 요소를 꺼내 element 대입

      if ("stream".equals(element)) {
        System.out.println("걸러낸 값 : " + element);
      }
    }

    /* 위 동작을 Stream을 이용해서 수행 */
    list
        .stream()
        .filter("stream"::equals) // .filter(element->"stream".equals(element))
        .forEach(str -> System.out.println("필터링된 값 : " + str));

  }
}
