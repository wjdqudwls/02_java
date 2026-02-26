package org.ho.section02.enumtype;

public enum FoodsEnum {
  MEAL_AN_BUTTER_KIMCHI_STEW(0),
  MEAL_MINT_SEAWEED_SOUP(1),
  MEAL_BUNGEOPPANG_SUSHI(2),

  DRINK_RADISH_KIMCHI_LATTE(0),
  DRINK_WOOLUCK_SMOOTHIE(1),
  DRINK_RAW_CUTTLEFISH_SHAKE(2);

  //필드
  private/* final */int value; //필드는 1개 있는거임
  private final int var = 10;

  // 생성자
  /*public*/ FoodsEnum(int value){ // Enum 생성자는 어디서나 쓸 수 없기에, public이 안됨
    this.value = value;
  }

  // getter
  public int getValue(){
    return value;
  }

  //메서드

  // 이거는 Objects.toString()이 아니라 Enum의 toString()?
  @Override
  public String toString() {
    // name() : 상수명 반환
    return name().toLowerCase();
  }

  public void printVar(){
    System.out.println("var = " + var);
  }
}
