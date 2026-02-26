package com.ohgiraffers.section01.intro;

public class Application1 {
    public static void main(String[] args) {

        /* 인터페이스에 정의된 추상 메서드를 활용하는 방법 */

        /* 1. 인터페이스를 상속 받은 클래스를 이용해서 추상 메서드를 오버라이딩 */
        Calculator c1 = new CalculatorImpl();
        System.out.println(c1.sumTwoNumber(10, 20));

        /* 2. 익명 내부 클래스를 사용해서 추상 메서드 오버라이딩 */
        // 인터페이스를 이용해서 instance 만들기 즉석해서 오버라이딩(익명 내부 클래스)
        // -> 완성된 클래스
        Calculator c2 = new Calculator() {


            @Override
            ///  CalculatorImpl 에 있는거와 같음 (익명 내부 클래스)
            public int sumTwoNumber(int a, int b) {
                return a + b;
            }
        };

        System.out.println(c2.sumTwoNumber(20, 30));

        /* 3. 익명 내부 클래스 방식을 람다식(함수를 간단하게 만드는 식)으로 바꿔서 사용하는 방법 */

        /*
             Calculator c3 = new Calculator() {
                @Override
                public int sumTwoNumber
               (int a, int b)
               {return 0;
               }

        };*/
        // 위 코드를 이렇게 줄여서 만듬
        Calculator c3 = (a, b) -> a + b;
        System.out.println(c3.sumTwoNumber(40, 50));

        Calculator c4 = (a, b) -> a + b + 100;
        System.out.println(c4.sumTwoNumber(1, 2));


    }


}
