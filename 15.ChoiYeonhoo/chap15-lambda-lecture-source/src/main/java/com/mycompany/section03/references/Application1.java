package com.mycompany.section03.references;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Application1 {
  public static void main(String[] args) {

    /* 메서드 참조를 이해하고, 사용할 수 있다. */

    BiFunction<String,String,Boolean> biFunction;
    String str1 = "METHOD";
    String str2 = "METHOD";

    /* 람다식 버전 */

    biFunction = (s1, s2) -> s1.equals(s2);
    boolean result = biFunction.apply(str1, str2);
    System.out.println(result);

    /* 익명 내부 클래스 버전 */
    biFunction = new BiFunction<String, String, Boolean>() {
      @Override
      public Boolean apply(String s, String s2) {
        return s.equals(s2);
      }
    };
    
    /* .equals의 모양 : 
        String 을 두개 받고, Boolean을 반환

    *   public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        return (anObject instanceof String aString)
                && (!COMPACT_STRINGS || this.coder == aString.coder)
                && StringLatin1.equals(value, aString.value);*/

   /* 메서드 참조 버전 */

    biFunction = String::equals; // 정적 메소드 참조
    result = biFunction.apply("abc", "abc");
    System.out.println("result = " + result);

    System.out.println("-------------------------------------------------");

    Predicate<String> predicate;
    String sample = "hello world";

    /* 람다식 버전 */
    predicate = str -> sample.equals(str);
    result = predicate.test("bye world");
    System.out.println(result);

    /* 메서드 참조 버전 */
    predicate = sample::equals;
    result = predicate.test("hello world");
    System.out.println(result);


  }
}
