package com.ohgiraffers.section02.set;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Application3 {
    public static void main(String[] args) {
        /* 로또 번호 생성기 */
       // Set<Integer> lotto = new HashSet<>();
        Set<Integer> lotto = new TreeSet<>();

        lotto.add(26);
        lotto.add(46);
        lotto.add(6);
        lotto.add(3);
        lotto.add(41);
        lotto.add(2);
        lotto.add(22);
        lotto.add(5);
        lotto.add(14);

        System.out.println("lotto = " + lotto);
        System.out.println("========================");

      //  Set<Integer> lotto = new HashSet<>();

        Random rand = new Random();
        while(lotto.size() < 6){
            int num = rand.nextInt(45)+1; // 1 ~ 45
            lotto.add(num);

            System.out.println("lotto = " + lotto);
            System.out.println("========================");
        }

    }


}
