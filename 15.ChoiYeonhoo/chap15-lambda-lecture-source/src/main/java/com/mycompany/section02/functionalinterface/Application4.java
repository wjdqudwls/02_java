package com.mycompany.section02.functionalinterface;

import java.util.function.*;

public class Application4 {
  public static void main(String[] args) {

    /* 표준 함수형 인터페이스 중 Operator를 이해하고 사용할 수 있다.
    * Operator
    * - 매개변수와 반환 값의 **** 타입이 같은 **** 함수형 인터페이스
    * - 매개 변수와 반환형을 모두 가지고 있는 applyXXX() 메서드를 가지고 있다.
    * */

    /* 1. BinaryOperator<T>#apply(T t1, T t2) : T : T와 T를 연산하여 T를 리턴한다.
     *     BiFunction을 상속받아 구현했기 때문에 동일하게 apply를 사용할 수 있다.
     * */
    BinaryOperator<String> binaryOperator = (str1, str2) -> str1 + str2;
    System.out.println("BinaryOperator: " + binaryOperator.apply("hello", "world"));

    /* 2. UnaryOperator<T>#apply(T t) : T : T를 연산하여 T를 리턴한다. */
    UnaryOperator<String> unaryOperator = (str) -> str + "world";
    System.out.println("UnaryOperator: " + unaryOperator.apply("hello"));

    /* 3. DoubleBinaryOperator#applyAsDouble(double d1, double d2) : double : 매개변수 두 개를 이용하여 연산 후 double 타입으로 리턴한다. */
    DoubleBinaryOperator doubleBinaryOperator = (d1, d2) -> d1 + d2;
    System.out.println("DoubleBinaryOperator: " + doubleBinaryOperator.applyAsDouble(10.5, 20.3));

    /* 4. DoubleUnaryOperator#applyAsDouble(double d) : double : 매개변수 한 개를 이용하여 연산 후 double 타입으로 리턴한다. */
    DoubleUnaryOperator doubleUnaryOperator = d -> d * 2;
    System.out.println("DoubleUnaryOperator: " + doubleUnaryOperator.applyAsDouble(15.5));

    /* 5. IntBinaryOperator#applyAsInt(int i1, int i2) : int : 매개변수 두 개를 이용하여 연산 후 int 타입으로 리턴한다. */
    IntBinaryOperator intBinaryOperator = (i1, i2) -> i1 * i2;
    System.out.println("IntBinaryOperator: " + intBinaryOperator.applyAsInt(10, 20));

    /* 6. IntUnaryOperator#applyAsInt(int i) : int : 매개변수 한 개를 이용하여 연산 후 int 타입으로 리턴한다. */
    IntUnaryOperator intUnaryOperator = i -> i * i;
    System.out.println("IntUnaryOperator: " + intUnaryOperator.applyAsInt(5));

    /* 7. LongBinaryOperator#applyAsLong(long l1, long l2) : long : 매개변수 두 개를 이용하여 연산 후 long 타입으로 리턴한다. */
    LongBinaryOperator longBinaryOperator = (l1, l2) -> l1 - l2;
    System.out.println("LongBinaryOperator: " + longBinaryOperator.applyAsLong(100L, 30L));

    /* 8. LongUnaryOperator#applyAsLong(long l) : long : 매개변수 한 개를 이용하여 연산 후 long 타입으로 리턴한다. */
    LongUnaryOperator longUnaryOperator = l -> l + 100L;
    System.out.println("LongUnaryOperator: " + longUnaryOperator.applyAsLong(50L));
  }
}
