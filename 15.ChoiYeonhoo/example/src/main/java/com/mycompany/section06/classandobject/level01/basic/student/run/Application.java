package com.mycompany.section06.classandobject.level01.basic.student.run;

import com.mycompany.section06.classandobject.level01.basic.student.model.dto.StudentDTO;

import java.util.Scanner;

public class Application {
  public static void main(String[] args) {

    // 최대 10명의 학생에 대한 정보를 기록할 수 있는 프로그램이다.
    // 해당 학생의 학년, 반, 이름, 국어, 수학, 영어 점수를 기록하고 평균을 구해보시오.
    // 해당 구현 클래스 다이어그램과 클래스 구조를 참고하여 프로젝트를 완성하시오.

    StudentDTO[] student = new StudentDTO[10];
    Scanner sc = new Scanner(System.in);

    int inputCount = 0;

    do {

      System.out.print("학년 : ");
      int grade = sc.nextInt();
      sc.nextLine();

      System.out.print("반 : ");
      int classroom = sc.nextInt();
      sc.nextLine();

      System.out.print("이름 : ");
      String name = sc.nextLine();

      System.out.print("국어점수 : ");
      int kor = sc.nextInt();
      sc.nextLine();

      System.out.print("영어점수 : ");
      int eng = sc.nextInt();
      sc.nextLine();

      System.out.print("수학점수 : ");
      int math = sc.nextInt();
      sc.nextLine();

      // 학생 정보 array에 추가


      System.out.print("계속 추가할 겁니까 ? (y/n) : ");
      char str = sc.nextLine().charAt(0);

      if (str == 'y') {
        return;
      } else break;

    }
    while (inputCount < 3);


  }
}
