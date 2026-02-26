package org.ho.section02.set;

import java.util.*;

public class Application3 {
  public static void main(String[] args) {
    /* 로또 번호 생성기 */

    Set<Integer> lotto = new TreeSet<>();

    Random rand = new Random();

    while (lotto.size() < 6) {
      int num = rand.nextInt(45) + 1; //1~45
      lotto.add(num);
    }

    System.out.println(lotto);
  }
}
