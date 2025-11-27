package com.ohgiraffers.section01.extend;

public class F1Car extends RacingCar {

  public F1Car() {
    super();
    System.out.println("F1Car 기본 생성자 호출됨.");
  }

  // Car -> RacingCar -> F1Car 오버라이딩
  @Override // 이름은 같은데 안에 기능 바꾸고 싶을 때 Override
  public void stop() {
    System.out.println("F1 자동차가 멈춥니다.");
  }
}
