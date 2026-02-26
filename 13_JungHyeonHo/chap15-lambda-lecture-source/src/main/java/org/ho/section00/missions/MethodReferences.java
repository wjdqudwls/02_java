package org.ho.section00.missions;

import java.util.*;
import java.util.stream.Collectors;

public class MethodReferences {
  public static void main(String[] args) {
    //1
    List<String> strList = new ArrayList<>();
    for (int f = 'a'; f <= 'e'; f++) {
      for (int s = 'A'; s <= 'E'; s++) {
        strList.add((char)f+""+(char)s);
      }
    }
    System.out.println("strList = " + strList);
    strList=strList.stream().map(str -> str.toUpperCase()).toList();
    System.out.println("strList(modified) = " + strList);
    //2
    Random rand = new Random();
    int[] intArr = new int[100];
    for(int i=0;i<100;i++){
      intArr[i] = rand.nextInt(1000)+1;
    }
    System.out.print("intArray = ");
    Arrays.stream(intArr).limit(10).forEach(num -> System.out.print(num+" "));
    //3
    Member[] members = new Member[5];

    members[0] = new Member("asdf");
    members[1] = new Member("zxcv");
    members[2] = new Member("zxcvq");

    System.out.println();
    System.out.println(Arrays.toString(members));
    List<Member> memList = Arrays.stream(members).filter(mem -> !Objects.isNull(mem)).collect(Collectors.toList());
    System.out.println(memList);


  }
}
