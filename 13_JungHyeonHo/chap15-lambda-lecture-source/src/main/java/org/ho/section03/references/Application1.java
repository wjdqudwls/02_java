package org.ho.section03.references;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Application1 {
  public static void main(String[] args) {
    /* 메서드 참조를 이해하고 사용할 수 있다. */
    //정적 메서드 참조
    BiFunction<String, String, Boolean> biFunction;
    String str1 = "METHOD";
    String str2 = "METHOD";

    /* 람다식 버전 */
    biFunction = (s1,s2) ->  s1.equals(s2);
    boolean result = biFunction.apply(str1, str2);
    System.out.println("result(lambda) = " + result);

    /* 익명 내부 클래스 */
    biFunction = new BiFunction<String, String, Boolean>() {
      @Override
      public Boolean apply(String s, String s2) {
        return s.equals(s2);
      }
    };

    /* 메서드 참조 버전 */
    biFunction = String::equals;
    System.out.println("result(method preferences) = " + biFunction.apply("abc","abd"));

    System.out.println("-----------------------------------------------");

    /*-------------------------------------------------------------------------*/
    // 다른 예시
    // 인스턴스 메서드 참조
    Predicate<String> predicate;
    String sample = "hello world";

    /* 람다식 버전 */
    predicate = (str) -> sample.equals(str);
    System.out.println("predicate.test(\"bye world\") = " + predicate.test("bye world"));

    /* 메서드 참조 버전*/
    // predicate는 String을 전달받기로 약속되어있다. 그래서 자동으로 매핑할 수 있다.
    predicate = sample::equals;
    // 그럼 객체, 매개변수, 리턴의 형태를 고려하면 되는건가
  }
}
