package com.mycompany.section02.functionalinterface;

import java.util.function.*;

public class Application3 {
  public static void main(String[] args) {
    /* 표준 함수형 인터페이스 중에서 Function을 이해하고 사용할 수 있다.
    *
    * Function
    * - 매개변수를 받아서 다른 타입으로 변환하여 반환하는 함수형 인터페이스
    * - 매개 변수와 반환형을 모두 가지고 있는 applyXXX() 메서드를 가지고 있다.
    *  */

    /* 1. Function<T, R>#apply(T t) : R : 객체 T를 R로 매핑한다. */
    Function<String, Integer> function = (str) -> Integer.parseInt(str);
    String strValue = "12345";
    System.out.println("Function: " + function.apply(strValue) + " : " + function.apply(strValue).getClass().getName());

    /* 2. BiFunction<T, U, R>#apply(T t, U u) : R : 객체 T와 U를 R로 매핑한다. */
    BiFunction<String, String, Integer> biFunction = (str1, str2) -> Integer.parseInt(str1) + Integer.parseInt(str2);
    String str1 = "12345";
    String str2 = "67890";
    System.out.println("BiFunction: " + biFunction.apply(str1, str2) + " : " + biFunction.apply(str1, str2).getClass().getName());

    /* 3. IntFunction<R>#apply(int value) : R : int를 R로 매핑한다. */
    IntFunction<String> intFunction = intValue -> String.valueOf(intValue);
    int intValue = 123;
    System.out.println("IntFunction: " + intFunction.apply(intValue) + " : " + intFunction.apply(intValue).getClass().getName());

    /* 4. IntToDoubleFunction#applyAsDouble(int value) : double : int를 double로 매핑한다. */
    IntToDoubleFunction intToDouble = num -> (double) num;
    System.out.println("IntToDoubleFunction: " + intToDouble.applyAsDouble(123)); // 123.0

    /* 5. IntToLongFunction#applyAsLong(int value) : long : int를 long으로 매핑한다. */
    IntToLongFunction intToLong = num -> (long) num;
    System.out.println("IntToLongFunction: " + intToLong.applyAsLong(123));

    /* 6. DoubleFunction<R>#apply(double value) : R : double을 R로 매핑한다. */
    DoubleFunction<String> doubleToString = num -> String.format("%.2f", num);
    System.out.println("DoubleFunction: " + doubleToString.apply(123.456));

    /* 7. LongToDoubleFunction#applyAsDouble(long value) : double : long을 double로 매핑한다. */
    LongToDoubleFunction longToDouble = num -> (double) num;
    System.out.println("LongToDoubleFunction: " + longToDouble.applyAsDouble(123L));

    /* 8. LongToIntFunction#applyAsInt(long value) : int : long을 int로 매핑한다. */
    LongToIntFunction longToInt = num -> (int) num;
    System.out.println("LongToIntFunction: " + longToInt.applyAsInt(123L));

    /* 9. ToDoubleBiFunction<T, U>#applyAsDouble(T t, U u) : double : 객체 T와 U를 double로 매핑한다. */
    ToDoubleBiFunction<String, String> toDoubleBiFunction = (s1, s2) -> Double.parseDouble(s1) + Double.parseDouble(s2);
    System.out.println("ToDoubleBiFunction: " + toDoubleBiFunction.applyAsDouble("123.456", "789.012"));

    /* 10. ToDoubleFunction<T>#applyAsDouble(T t) : double : 객체 T를 double로 매핑한다. */
    ToDoubleFunction<String> parseToDouble = str -> Double.parseDouble(str);
    System.out.println("ToDoubleFunction: " + parseToDouble.applyAsDouble("123.45"));

    /* 11. ToIntBiFunction<T, U>#applyAsInt(T t, U u) : int : 객체 T와 U를 int로 매핑한다. */
    ToIntBiFunction<String, String> toIntBiFunction = (s1, s2) -> Integer.parseInt(s1) + Integer.parseInt(s2);
    System.out.println("ToIntBiFunction: " + toIntBiFunction.applyAsInt("123", "456"));

    /* 12. ToIntFunction<T>#applyAsInt(T t) : int : 객체 T를 int로 매핑한다. */
    ToIntFunction<String> toIntFunction = str -> Integer.parseInt(str);
    System.out.println("ToIntFunction: " + toIntFunction.applyAsInt("789"));

    /* 13. ToLongBiFunction<T, U>#applyAsLong(T t, U u) : long : 객체 T와 U를 long으로 매핑한다. */
    ToLongBiFunction<String, String> toLongBiFunction = (s1, s2) -> Long.parseLong(s1) + Long.parseLong(s2);
    System.out.println("ToLongBiFunction: " + toLongBiFunction.applyAsLong("123456", "789012"));

    /* 14. ToLongFunction<T>#applyAsLong(T t) : long : 객체 T를 long으로 매핑한다. */
    ToLongFunction<String> toLongFunction = str -> Long.parseLong(str);
    System.out.println("ToLongFunction: " + toLongFunction.applyAsLong("123456789"));
  }
}
