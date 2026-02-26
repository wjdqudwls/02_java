package org.ho.section00.missions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Lambda {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i <= 10; i++) {
      list.add(i);
    }
    Optional<Integer> sum = list.stream().filter(n -> n % 2 == 0).map(n -> n * 2).reduce(Integer::sum);
    System.out.println("sum = " + sum.orElse( 0));
  }
}
