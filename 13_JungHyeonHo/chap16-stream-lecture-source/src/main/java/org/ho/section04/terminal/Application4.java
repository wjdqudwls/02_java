package org.ho.section04.terminal;

import java.util.Arrays;
import java.util.List;

public class Application4 {
  public static void main(String[] args) {

    List<String> stringList = Arrays.asList("Java", "Spring", "SpringBoot");

    boolean anyMatch = stringList.stream()
        .anyMatch(str -> str.contains("p"));
    System.out.println("anyMatch = " + anyMatch);

    boolean allMatch = stringList.stream()
        .allMatch(str -> str.length() > 4);
    System.out.println("allMatch = " + allMatch);

    boolean noneMatch = stringList.stream()
        .noneMatch(str -> str.contains("c"));
    System.out.println("noneMatch = " + noneMatch);

  }
}
