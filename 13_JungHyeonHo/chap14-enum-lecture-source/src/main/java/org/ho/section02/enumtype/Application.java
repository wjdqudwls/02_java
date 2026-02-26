package org.ho.section02.enumtype;

public class Application {
  public static void main(String[] args) {

    /* 1. 열거 타입은 싱글톤 방식으로 구현되기 때문에 인스턴스의 생성이나 확장이 되지 않는다.
          즉, 인스턴스가 통제되며 하나만 존재하는 것이 보장된다.*/
    System.out.println(FoodsEnum.MEAL_AN_BUTTER_KIMCHI_STEW);
    System.out.println(FoodsEnum.MEAL_AN_BUTTER_KIMCHI_STEW.ordinal());

    boolean isTrue = enumTest(
        FoodsEnum.MEAL_AN_BUTTER_KIMCHI_STEW,
        FoodsEnum.DRINK_WOOLUCK_SMOOTHIE);
    System.out.println("isTrue = " + isTrue);

    /* 5. 열거 타입에 메서드나 필드를 추가 할 수 있다. */
    FoodsEnum.MEAL_BUNGEOPPANG_SUSHI.printVar();

    /* 7. 열거 타입 내에 선언된 상수들을 순회할 수 있다. */
    for (FoodsEnum food : FoodsEnum.values()) {
      System.out.println("food = " + food);
      System.out.println("food.getValue() = " + food.getValue());
      food.printVar();
      System.out.println("-----");
    }
  }

  private static boolean enumTest(
      FoodsEnum foodsEnum1, FoodsEnum foodsEnum2) {

    System.out.println("foodsEnum1 = " + foodsEnum1);
    System.out.println("foodsEnum1.getValue() = " + foodsEnum1.getValue());

    System.out.println("foodsEnum2 = " + foodsEnum2);
    System.out.println("foodsEnum2.getValue() = " + foodsEnum2.getValue());

    if (foodsEnum1 == foodsEnum2) return true;
    if (foodsEnum1.getValue() == foodsEnum2.getValue()) return true;

    return false;
  }
}
