package com.my.section03.filterstream;

import java.io.*;

public class Application3 {
  public static void main(String[] args) {

    /* DataInputStream/OutputStream
     * - 데이터 입출력 보조 스트림
     * - 자료형을 그대로 출력
     * - 입력된 데이터의 자료형을 바로 판별
     * */

    try (DataOutputStream dos
             = new DataOutputStream(new FileOutputStream("score.txt"))) {

      dos.writeUTF("홍길동"); // 문자열 "홍길동" 출력
      dos.writeInt(95); // int 95 출력
      dos.writeChar('A');

      dos.writeUTF("이순신");
      dos.writeInt(85);
      dos.writeChar('B');

      dos.writeUTF("유관순");
      dos.writeInt(75);
      dos.writeChar('C');


    } catch (IOException e) {
      System.out.println(e.getMessage());
    }


    /* DataOutputStream으로 출력한 데이터 입력 받기 */
    try (DataInputStream dis
             = new DataInputStream(new FileInputStream("score.txt"))) {

      while(true){
        /* - 파일에 기록된 순서대로 읽어와야 한다!!
        * (순서가 다르면 의미 없는 데이터를 읽어오게 됨)
        *
        * - 더 이상 파일에서 읽어올 데이터가 없다면
        * EOFException이 발생되어 자동으로 종료
        * (EOF == End Of File)
        * */

        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readChar());
      }

    } catch(EOFException e){
      System.out.println("파일 읽기 완료");
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

  }


}
