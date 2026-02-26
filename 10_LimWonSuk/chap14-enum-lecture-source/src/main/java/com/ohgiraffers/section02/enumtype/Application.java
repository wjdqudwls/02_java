package com.ohgiraffers.section02.enumtype;

public class Application {
    public static void main(String[] args) {

        /* 1. 열거 타입은 싱글톤 방식으로 구현되기 때문에 인스턴스의 생성이나 확장이 되지 않는다.  */

        /* 2. 열거 타입은 컴파일 타임 타입 안전성을 높여준다. */

        System.out.println(FoodsEnum.MEAL_AN_BUTTER_KIMCHI_STEW);
        System.out.println(FoodsEnum.MEAL_AN_BUTTER_KIMCHI_STEW.ordinal());

        boolean isTrue = enumTest(
                FoodsEnum.MEAL_AN_BUTTER_KIMCHI_STEW,
                FoodsEnum.DRINK_RADISH_KIMCHI_LATTE
        );

        System.out.println("isTrue : " + isTrue);
        /* 4. 열거 타입은 상수 이름을 문자열로 출력할 수 있다.
        * 열거 타입도 클래스이기 때문에 toString() 을 재정의하여 사용할 수 있다. */
        System.out.println("=============소문자 출력 열거타입 인스턴스 확인 =============");
        {

            System.out.println(FoodsEnum.MEAL_AN_BUTTER_KIMCHI_STEW);
            System.out.println(FoodsEnum.MEAL_MINT_SEAWEED_SOUP);
            System.out.println(FoodsEnum.MEAL_BUNGEOPPANG_SUSHI);
            System.out.println(FoodsEnum.DRINK_RADISH_KIMCHI_LATTE);
            System.out.println(FoodsEnum.DRINK_WOOLUCK_SMOOTHIE);
            System.out.println(FoodsEnum.DRINK_RAW_CUTTLEFISH_SHAKE);

            /* 5. 열거 타입에 메서드나 필드를 추가 할 수 있다 */
            FoodsEnum.MEAL_BUNGEOPPANG_SUSHI.printVar();

            /* 7. 열거 타입 내에 선언된 상수들을 순회할 수 있다. */
            for(FoodsEnum food : FoodsEnum.values()){
                System.out.println("food = " + food);
                System.out.println("food.getValue = " + food.getValue());
               food.printVar();
            }


        }
    }

    private static boolean enumTest(FoodsEnum foodsEnum1,
                                    FoodsEnum foodsEnum2) {

        System.out.println("foodsEnum1 = " + foodsEnum1);
        System.out.println("foodsEnum1.getValue() = " + foodsEnum1.getValue());

        System.out.println("foodsEnum2 = " + foodsEnum2);
        System.out.println("foodsEnum2.getValue() = " + foodsEnum2.getValue());

        if (foodsEnum1 == foodsEnum2) return true;
        return false;
    }
}
