package com.ohgiraffers.section03.references;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Application1 {
    public static void main(String[] args) {
        
        /*메서드 참조를 이해하고 사용할 수 있다. */
        BiFunction<String, String, Boolean> biFunction;
        String str1 = "METHOD";
        String str2 = "METHOD";

        
        /* 럼다식 버전 */
        biFunction = (s1, s2) ->  s1.equals(s2); // return  구문 s1.equals(s2); 여길 잘봐야 이해함
        boolean result = biFunction.apply(str1, str2);

        System.out.println("resuilt = " + result);


        /* 익명 내부 클래스 */
         biFunction = new BiFunction<String, String, Boolean>() {
             @Override
             public Boolean apply(String s, String s2) {
                 return s.equals(s2);
             }
         };
        System.out.println(" ============================= ");

        /* 메서드 참조 버전 */
       // biFunction = String::equals;
        biFunction = String::equals;
        result = biFunction.apply("abc", "abc");
        System.out.println("resuilt = " + result);
        System.out.println(" ============================= ");
        Predicate<String> predicate;
        String sample = "Hello World";

        /* 람다식 버전 */
        predicate = str -> str.equals(sample); ;
        result = predicate.test("Bye World");
        System.out.println("result = " + result);

        /* 메서드 참조 버전 */
        predicate = sample::equals;
        predicate = str -> str.equals(sample); ;
        result = predicate.test("Hello World");
        System.out.println("result = " + result);


        
    }
}
