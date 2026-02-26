package com.beyond.section03.intermediate;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Application3 {
  public static void main(String[] args) {

    List<List<String>> list = Arrays.asList(Arrays.asList("JAVA", "SPRING", "SPRINGBOOT"),
        Arrays.asList("java", "spring", "springboot"));

    System.out.println("list = " + list);

    List<String> flatList = list.stream()
    //    .flatMap(Collection::stream) // 메서드 참조

        // list 스트림에서 꺼낸 List<String> 객체를 스트림화 후 하나의 스트림으로 만들기
        .flatMap(l-> l.stream()) // 람다식
        .collect(Collectors.toList()); // 스트림을 이용해 컬렉션 List 생성


    System.out.println("flatList = " + flatList);
  }
}
