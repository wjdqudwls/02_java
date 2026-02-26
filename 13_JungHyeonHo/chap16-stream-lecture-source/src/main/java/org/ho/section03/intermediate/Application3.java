package org.ho.section03.intermediate;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application3 {
  public static void main(String[] args) {
    List<List<String>> list
        = Arrays.asList(Arrays.asList("JAVA", "SPRING", "SPRINGBOOT"),
        Arrays.asList("java", "spring", "springboot"));


    System.out.println("list = " + list);

    List<String> flatList = list.stream()// list 안에는 List<String>들이 있음=> stream() = List<String>
        //.flatMap(Collection::stream)        // List<String>을 평평하게
        .flatMap(l -> l.stream())   // =List<String> 객체를 stream()을 통해 스트림화
                                              // 각 List<String> 스트림을 flatMap()으로 하나의 스트림으로 합치기
        .collect(Collectors.toList());        // 스트림을 이용해 컬렉션 List 생성

    System.out.println("flatList = " + flatList);
  }
}
