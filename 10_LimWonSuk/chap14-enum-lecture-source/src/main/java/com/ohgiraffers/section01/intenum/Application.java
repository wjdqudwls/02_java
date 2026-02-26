package com.ohgiraffers.section01.intenum;

public class Application {
    public static void main(String[] args) {

        /* 1. 타입 안정성 보장 방법이 없어 디버깅이 어렵다. */
       //  int food = Foods.MEAL_AN_BUTTER_KIMCHI_STEW;        // 상수값 : 0
        int food = Foods.MEAL_AN_BUTTER_KIMCHI_STEW; // 상수값 : 0

        // food = Foods.DRINK_RADISH_KIMCHI_LATTE;             // 상수값 : 0

        /*  2. 두상수의 값이 모두 0 이기 때문에
         if 조건은 만족하나 정확히 무엇을 나타낸느 상수인지 알 수 없다*/

       // if(food == 0){
        if(food == Foods.MEAL_AN_BUTTER_KIMCHI_STEW){
            System.out.println("식사 카테고리 - 앙버터 김치찜");
        }

        {

            System.out.println(Foods.MEAL_AN_BUTTER_KIMCHI_STEW);
            System.out.println(Foods.MEAL_MINT_SEAWEED_SOUP);
            System.out.println(Foods.MEAL_BUNGEOPPANG_SUSHI);

            System.out.println(Foods.DRINK_RADISH_KIMCHI_LATTE);
            System.out.println(Foods.DRINK_WOOLUCK_SMOOTHIE);
            System.out.println(Foods.DRINK_RAW_CUTTLEFISH_SHAKE);

            /* 3. 정수 열거 그룹에 속한 모든 상수를 순회하는 방법도 쉽지 않다 */

            /* 4. */
        }


    }

    }
