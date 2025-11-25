package com.qew032.section02.looping;

import java.util.Scanner;

public class Application {

  public static void main(String[] args) {
     A_for aFor = new A_for();
//     aFor.testSimpleForStatement();;
//    aFor.testForExample1();

//    aFor.testForExample2();

//    aFor.tesForExample3();

//    aFor.tesForExample4();

    B_nestedFor b_nestedfor = new B_nestedFor();
//    b_nestedfor.printTable();
//    b_nestedfor.printTable2();
//    b_nestedfor.printGugudan();
//    b_nestedfor.printTriangleStar();

    C_while c_while = new C_while();
//    c_while.testSimpleWhileStatement();
//    c_while.testSimpleWhileExample1();
//      c_while.testSimpleDoWhileStatement();

    /* aqirxh + do~while */
    Scanner sc = new Scanner(System.in);

    int input = 0;

    do {
      System.out.println("===== while 예시 선택 메뉴 =====");
      System.out.println("1. testSimpleWhileStatement");
      System.out.println("2. testSimpleWhileExample1");
      System.out.println("3. testSimpleDoWhileStatement");
      System.out.println("0. 종료");
      System.out.print("메뉴 번호 입력 >> ");
      input = sc.nextInt();
      sc.nextLine();

      switch (input) {
        case 1:
          c_while.testSimpleWhileStatement();
          break;
        case 2:
          c_while.testSimpleWhileExample1();
          break;
        case 3:
          c_while.testSimpleDoWhileStatement();
          break;
        case 0:
          System.out.println("===== 프로그램 종료 =====");
          break;
        default:
          System.out.println("메뉴에 없는 번호를 입력함");
      }
    } while (input != 0);;


  }

}
