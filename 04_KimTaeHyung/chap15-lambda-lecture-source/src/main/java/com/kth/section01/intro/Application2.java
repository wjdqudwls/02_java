package com.kth.section01.intro;

public class Application2 {
  public static void main(String[] args) {

    /* 내부 인터페이스를 람다식으로 구현하기 */

    /* 익명 내부 클래스로 구현하기 */
    OuterInterface.Sum sum = new OuterInterface.Sum(){
      @Override
      public int sumTwoNumber(int a, int b) {
        return a + b;
      }
    };

    System.out.println("sum.sumTwoNumber(10, 20) : " + sum.sumTwoNumber(10, 20));

    /* 람다식 사용 */
    /* {} 내부 코드가 한 줄인 경우 {} 생략 가능
    *  단, 한 줄인 코드가 return 구문이면 return도 생략 가능
    * */
    OuterInterface.Sum sum2 = ( a,  b) -> a + b;
    OuterInterface.Minus minus = (a, b ) -> a - b;
    OuterInterface.Multiple multiple = (a, b) -> a * b;

    /* {} 내 코드가 한 줄 초과 시 {} 생략 불가 */
    OuterInterface.Divide divide = (a, b) -> {
      if(b == 0) return 0;
      return a / b;
    };


  }
}
