package com.my.section02.stream;

import java.io.FileReader;
import java.io.IOException;

public class Application2 {
  public static void main(String[] args) {

    /* FileReader 클래스
    * - 파일의 내용을 문자 단위로 읽어오는 클래스
    * */

    /* try - with - resources */
    try(FileReader fr = new FileReader("testReader.txt")) {

      // 1) 문자 하나씩 읽어오기
//      int value;
//      while( (value = fr.read()) != -1 ){
//        System.out.print((char)value);
//      }

      // 2) char[]로 읽어오기
      char[] arr = new char[1500];
      fr.read(arr);

      for(char ch : arr){
        System.out.print(ch);
      }

    }catch (IOException e){
      System.out.println(e.getMessage());
    }

  }
}
