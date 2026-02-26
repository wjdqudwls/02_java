package com.mycompany.section04.terminal;

import java.util.Arrays;
import java.util.List;

public class Application4 {
  public static void main(String[] args) {

    List<String> stringList = Arrays.asList("Java", "Spring", "SpringBoot");

    boolean anyMatch = stringList.stream()
        .anyMatch(str -> str.contains("p")); // true <- (false, true, true)

    boolean allMatch = stringList.stream()
        .allMatch(str -> str.length() > 4);  // false <- (false, true, true)

    boolean noneMatch = stringList.stream()
        .noneMatch(str -> str.contains("c")); // true <- (false, false, false)

    System.out.println("anyMatch = " + anyMatch);
    System.out.println("allMatch = " + allMatch);
    System.out.println("noneMatch = " + noneMatch);
  }
}
