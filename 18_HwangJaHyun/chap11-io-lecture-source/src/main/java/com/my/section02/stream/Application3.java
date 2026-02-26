package com.my.section02.stream;

import java.io.FileOutputStream;
import java.io.IOException;

public class Application3 {
  public static void main(String[] args) {

    /* FileOutputStream
    * - 바이트 기반 파일 출력 스트림
    *   (java -> 파일)
    * */

    /* 파일 출력 스트림의 대상이 존재하지 않는다면
    * 자동으로 파일이 생성된다!
    * 단, 경로가 잘못되면 FileNotFoundException 발생
    *
    * - append option
    *   - true 설정: 이어쓰기
    *   - false 설정: 덮어쓰기(기본값)
    * */
    try(FileOutputStream fos
            = new FileOutputStream("testOutputStream.txt", false)){
      // 1) 1 byte씩 출력하기
     /* fos.write('A');
      fos.write('B');
      fos.write('\n');
      fos.write('C');
      fos.write('D');
      fos.write('가');
      fos.write('나');
      fos.write('백'); // 한글 깨짐*/

      // 2) byte[] 출력하기
      // - 1바이트 단위로 출력하지만
      //   배열로 묶어서 출력하면 글자가 깨지지 않음
      byte[] bytes = {97,98,99,100,101};
      bytes = "백동현".getBytes();
      fos.write(bytes);

      fos.write(new byte[]{65,66,67,68,69,70}, 1, 3);


      
      System.out.println("===== 파일 출력 완료 =====");

    }catch (IOException e){
      System.out.println(e.getMessage());
    }
  }
}
