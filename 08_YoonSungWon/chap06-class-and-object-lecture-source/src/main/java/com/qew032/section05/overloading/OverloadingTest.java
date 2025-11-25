package com.qew032.section05.overloading;

public class OverloadingTest {

    /*  오버로딩
    *   - 같은 클래스 내에서 같은 이름의 메서드를 작성하는 기법
    *
    *   사용 이유
    *   - 매개 변수의 종류에 따라서 메서드 동작이 조금씩 달라지는 경우
    *   서로 다른 이름으로 메서드를 관리하면 어렵기 때문에
    *   하나의 이름으로 관리
    *
    *   성립 요건
    *   1. 메서드 이름이 같아야 한다.
    *   2. 매개변수의 타입 순서 개수 중 하나라도 달라야한다.
    *   3. 접근제어자, 반환형, 예외처리 신경 X
    * */

    public static void main(String[] args) {
            OverloadingTest overloadingTest = new OverloadingTest();

    }

    public  void test1() {}
    public  void test1(int num) {}
    public  void test1(double num) {}
    public  void test1(String name, double num) {}
    public  void test1(double num,String name) {}
    public  void test1(String a, String b) {}

    // 에러 발생 -> 변수명이 달라져도 타입, 순서, 개수가 모두 일치함
    // public  void test1(String b, String c) {}


}
