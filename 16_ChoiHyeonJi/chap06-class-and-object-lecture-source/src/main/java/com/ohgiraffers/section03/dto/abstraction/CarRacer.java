package com.ohgiraffers.section03.dto.abstraction;

public class CarRacer {
  //필드
  private Car car = new Car(); // heap이라는 메모리 영역에 car 보고 똑같이 할당

  public void startUp(){ //차 시동on 기능 운전자가 시동on 호출
    car.startUp();
  }

  public void stepAccelerator(){
    car.go();
  }

  public void stepBreak(){
    car.stop();
  }

  public void turnOff(){
    car.turnOff();
  }





}
