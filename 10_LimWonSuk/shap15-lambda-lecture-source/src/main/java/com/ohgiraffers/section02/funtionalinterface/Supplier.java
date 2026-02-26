package com.ohgiraffers.section02.funtionalinterface;

import java.time.LocalDateTime;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;

public class Supplier {
    public static void main(String[] args) {
        /* 표준 함수형 인터페이스 중 Supplier를 이해하고 사용할 수 있다.
         *
         * Supplier(소비자)
         * - 매개 변수로없이 값을 제공하는 함수형. 인터페이스
         * - 리턴 값이 존재하는 getXXX()매서드를 가지고 있다
         * */

        /* 1. Supplier<T>#get() : T : 객체 T를 리턴한다. */
        /*
          Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
          System.out.println(supplier.get());
          여기 오류남 복붙했느데;;
         */

        /* 2. BooleanSupplier#getAsBoolean() : boolean : boolean값을 리턴한다. */
        BooleanSupplier booleanSupplier = () -> {
            int random = (int) (Math.random() * 2);
            return random == 0 ? false : true;
        };
        System.out.println("랜덤 true or false : " + booleanSupplier.getAsBoolean());



        /* 3. IntSupplier#getAsInt() : int : int값을 리턴한다. */
        IntSupplier intSupplier = () -> (int) (Math.random() * 6) + 1;
        System.out.println("주사위를 던져서 나온 수 : " + intSupplier.getAsInt());



        /* 4. DoubleSupplier#getAsDouble() : double : double값을 리턴한다. */
        DoubleSupplier doubleSupplier = () -> Math.random();
        System.out.println("Math.random()의 리턴값 : " + doubleSupplier.getAsDouble());



        /* 5. LongSupplier#getAsBoolean() : long : long값을 리턴한다. */
        LongSupplier longSupplier = () -> new java.util.Date().getTime();
        System.out.println("1970년 1월 1일 9시 0분 0초 이후 지난 시간 : " + longSupplier.getAsLong());


    }

}
