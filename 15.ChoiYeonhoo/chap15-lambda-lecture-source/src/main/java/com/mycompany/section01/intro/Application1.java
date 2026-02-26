package com.mycompany.section01.intro;

public class Application1 {
  public static void main(String[] args) {

    /* 인터페이스에 정의된 추상 메서드를 활용하는 방법 */

    /* 1. 인터페이스를 상속받은 클래스를 이용해서 추상 메서드를 오버라이딩 */
    Calculator c1 = new CalculatorImpl();
    System.out.println(c1.sumTwoNumber(10, 20));

    /* 2. 익명 내부 클래스를 사용해서 추상 메서드 오버라이딩 */
    /* 인터페이스를 이용해서 instance 만들기
    * 어떻게? 추상 메서드를 즉석에서 오버라이딩(익명 내부 클래스) 
    * -> 완성된 클래스 
    * 람다식은 이 익명 내부 클래스를 간단하게 작성하는 방법임*/
    Calculator c2 = new Calculator() {
      // 
      @Override
      public int sumTwoNumber(int a, int b) {
        return a + b;
      }
    };

    System.out.println(c2.sumTwoNumber(20, 30));
    
    /* 3. 익명 내부 클래스 방식을 람다식으로 바꿔서 사용하는 방법 */
    
    Calculator c3 = (int a, int b) ->  {return a + b;};

   
//    Calculator c3 = new Calculator() {  // 어짜피 new Calculator로 생성할거니까 삭제
//      public int sumTwoNumber(int a, int b) { // interface 내부에 어짜피 메서드 1개밖에 없으니 public int sumTwoNumber 삭제
//        return a + b; // 어짜피 a+b 리턴 할거니까 return 삭제 및 {}도 삭제
//      }
//    }; // 어짜피 이 안에 있으니까 {} 삭제

    Calculator c4 = (a,b) -> a+b+100;
    System.out.println(c4.sumTwoNumber(1, 2));
  }
}
