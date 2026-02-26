package com.ohgiraffers.section01.intro;

public interface Outerinterface {
    public static void main(String[] args) {

    }
    /* 내부 인터페이스
    * - 클래스 또는 인터페이스 내부에 작성된 인터페이스
    *
    * 람다식 사용을 위한 함수형 인터페이스를 만들때
    * 1 파일 형식 == 1 함수형 인터페이스 형태는 관리가 어려우므로
    * 내부 인터페이스를 이용해서 1파일 == N 함수형 인터페이스 형태로 효율적 관리 가능
    * */

    @FunctionalInterface
    interface Sum{
        int sumTwoNumber(int a, int b);
    }
    @FunctionalInterface
    interface Minus{
        int minusTwoNumber(int a, int b);
    }
    @FunctionalInterface
    interface Multiple{
        int multipleTwoNumber(int a, int b);
    }
    @FunctionalInterface
    interface Dvide{
        int divideTwoNumber(int a, int b);
    }

}
