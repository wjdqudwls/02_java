package com.ohgiraffers.section01.extend;

public class Application {
  public static void main(String[] args) {

    /* FireCar, RacingCar가 Car를 상속 받았는지 확인 */
    Car car = new Car();
    car.soundHorn();
    car.run();
    car.soundHorn();
    car.stop();

    System.out.println("--------------------");
    FireCar fireCar = new FireCar();
    fireCar.soundHorn();
    fireCar.run();
    fireCar.sparyWater();
    fireCar.soundHorn();
    fireCar.stop();

    System.out.println("--------------------");
    RacingCar racingCar = new RacingCar();
    racingCar.soundHorn();
    racingCar.run();
    racingCar.useBooster();
    racingCar.soundHorn();
    racingCar.stop();


    System.out.println("--------------------");
    F1Car f1Car = new F1Car();
    f1Car.run();
    f1Car.soundHorn();
    f1Car.useBooster();
    f1Car.stop();

  }
}
