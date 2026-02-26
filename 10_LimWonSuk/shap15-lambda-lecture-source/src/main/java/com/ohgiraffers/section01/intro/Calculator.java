package com.ohgiraffers.section01.intro;

/* 함수형 인터페이스
* - 인터페이스 내부에 추상 메서드가 1개 선언된 인터페이스
*
* @FunctionalInterface 어노테이션
* - 함수형 인터페이스 문법에 맞게 작성되었는지 확인하는
* */
public interface Calculator {
    int sumTwoNumber(int a, int b);

  //  void errorTest(); // 람다식은 메서드가 1개인 인터페이스 에서만 사용 가능 확인
}

