package com.my.section02.stream;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Application4 {
  public static void main(String[] args) {

    /* FileWriter
    * - 문자 기반 파일 출력 스트림
    * - String 출력 제공
    * */

    try(
        FileWriter fw = new FileWriter("testWriter.txt");
        Scanner sc = new Scanner(System.in);
    ){
      System.out.println("===== 원하는 문자열 입력 후 엔터(종료는 !wq) =====");

      StringBuilder sb = new StringBuilder();
      String input = null;

      do{
        input = sc.nextLine();
        if(input.equals("!wq")) break;

        sb.append(input);
        sb.append("\n"); // 줄바꿈 추가
      }while(true);

      fw.write(sb.toString());
      System.out.println("===== 파일 출력 완료 =====");

    }catch (IOException e){
      System.out.println(e.getMessage());
    }

  }
}
