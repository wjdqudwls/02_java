package com.ohgiraffers.section08.objectarray;

public class Application {
  public static void main(String[] args) {
    /* 객체 배열 선언 및 할당 */

    // 기본 자료형 아니면 다 참조
    Car[] cars = new Car[5];
    // new Car[5] : heap 영역에 Car 타입의 "참조형" 변수 5칸을 만들기 (주소 저장)
    // == Car 참조형 변수 5개 묶음


    // cars == Car 참조형 변수 5개가 묶인 배열을 참조하는 변수
    // car 배열은 만들었는데 car 만든 적은 xx
    System.out.println(cars[0]); // 이름 한번에 바꾸기 shift +f6 //자동완성 alt shift \
    cars[0] = new Car("페라리", 300);
    cars[1] = new Car("람보르기니", 350);
    cars[2] = new Car("롤스로이스", 250);
    cars[3] = new Car("부가티베이론", 400);
    cars[4] = new Car("포터", 500);

    /* 같은 타입의 객체를 묶어놓은 배열임을 알고 있기 때문에
    * for문으로 일괄 처리를 할 수 있다. */
    for (int i = 0; i < cars.length; i++) {
      cars[i].driveMaxSpeed();
    }

    int[] arr = {1,2,3,4,5};

    Car[] cars2 = { //new 연산자 쓰면 주소가 반환
        new Car("테슬라 사이버 트럭", 300),
        new Car("다마스", 140),
        cars[3] //car를 참조하는 주소가 들어가 있음 //얕은 복사
    };
        /* 향상된 for문 */
    for (Car car : cars2) {
      car.driveMaxSpeed();
    }
  }
}
