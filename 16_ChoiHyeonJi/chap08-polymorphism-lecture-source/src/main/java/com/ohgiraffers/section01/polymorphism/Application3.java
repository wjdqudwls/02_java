package com.ohgiraffers.section01.polymorphism;

public class Application3 {
  public static void main(String[] args) { // 같은 static 서로 호출하는데 문제 x
    feed(new Animal()); // new : heap에 객체 생성 후 주소 반환
    feed(new Tiger());
    feed(new Goat());
    feed(new Rabbit());
  }


  // 매개 변수 + 다형성 (업캐스팅)
  public static void feed(Animal animal) {
    animal.eat();
  }

  /* 만약 매개 변수 + 다형성(업캐스팅)을 몰랐을 경우
  * -> 모든 타입의 메서드를 오버로딩으로 구현 */
  /* 이런식으로 만들었을 거임..
  없어도 됨!!!
  public void feed(Tiger t){
    t.eat();
  }
  public void feed(Goat g){
    g.eat();
  }
*/

}
