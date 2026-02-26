package org.ho.section01.intro;

import java.util.PriorityQueue;

public class Application1 {
  public static void main(String[] args) {
    /* 인터페이스에 정의된 추상 메서드를 활용하는 방법 */

    /* 1. 인터페이스를 상속 받은 클래스를 이용해서 추상 메서드를 오버라이딩 */
    Calculator c1 = new CalculatorImpl();
    System.out.println("c1.sumTwoNumber(10,231) = " + c1.sumTwoNumber(10, 231));

    /* 2. 익명 내부 클래스를 사용해서 추상 메서드 오버라이딩 */
    Calculator c2 = new Calculator() {
      @Override
      public int sumTwoNumber(int a, int b) {
        return a + b;
      }
    };

    System.out.println(c2.sumTwoNumber(20, 30));

    /* 3. 익명 내부 클래스 방식을 람다식으로 바꿔서 사용하는 방법*/
//    Calculator c3 = (a,b)-> {return a+b;};
    Calculator c3 = (a, b) -> a + b;

    System.out.println("c3.sumTwoNumber(10,123) = " + c3.sumTwoNumber(10, 123));

    Calculator c4 = (a, b) -> a + b + 100;
    System.out.println(c4.sumTwoNumber(1,2));


  }
}
