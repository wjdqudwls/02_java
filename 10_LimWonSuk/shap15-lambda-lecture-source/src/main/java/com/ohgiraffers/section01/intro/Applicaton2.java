package com.ohgiraffers.section01.intro;

public class Applicaton2 {
    public static void main(String[] args) {
        /* 내부 인터페이스를 람다식으로 구현하기 */

        /* 익명 내부 클래스로 구형하기*/
        Outerinterface.Sum sum = new Outerinterface.Sum() {
            @Override
            public int sumTwoNumber(int a, int b) {
                return a + b;
            }
        };

        System.out.println("sum.sumTwoNumber(10,20) : " +
                "" + sum.sumTwoNumber(10,20));

        System.out.println("============== 위식을 밑의 람다식으로 ===============");

        /* 위식을 람다식 으로 사용
        *
        * 중괄호{} 내부 코드가 한줄인 경우 중괄호{}를 생략 할 수 있다
        *
        * 단, 한 줄인코드가 return 구문이면 return도 생략 가능
        * */
         Outerinterface.Sum sum2 = (  a,  b) ->  a + b;
         Outerinterface.Sum minus = (  a,  b) ->  a - b;
         Outerinterface.Sum multiple = (  a,  b) ->  a * b;

         /* {} 내 코드가 한 줄 초과 시 {} 생략 불가} */
         Outerinterface.Sum divide = (  a,  b) -> {
             if(b == 0) return 0; // if문 들어가면 중괄호 유지함
             return a/b;
         } ;


    }
}
