package com.my.section03.filterstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Application5 {
  public static void main(String[] args) {

    /* members.dat 파일 내용을 읽어와 출력  */
    try(ObjectInputStream ois =
            new ObjectInputStream(new FileInputStream("members.dat"))){

      // 읽어온 Object -> Member[] 다운 캐스팅
      // + 직렬화된 데이터를 원래 객체 상태로 바꿈 (역직렬화)
      Member[] inputMembers = (Member[])ois.readObject();

      for(Member mem : inputMembers){
        System.out.println(mem.toString());
      }

    } catch (IOException e){
      System.out.println(e.getMessage());

    } catch (ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }

  }
}
