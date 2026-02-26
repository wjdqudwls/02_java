package org.ho.section04.additional;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

/* @Order 어노테이션 기능 활성화를 위해 클래스 레벨에 추가하는 구문 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdditionalAnnotationTests {

//  @Disabled //비활성화
  @Test
  @Order(4) // 테스트 실행 순서
  void test1() {
    System.out.println("테스트1 수행");
  }

  @Test
  @Order(3) // 테스트 실행 순서
  void test2() {
    System.out.println("테스트2 수행");
  }

  @Test
  @Order(2) // 테스트 실행 순서
  void test3() {
    System.out.println("테스트3 수행");
  }

  @Test
  @Order(1) // 테스트 실행 순서
  void test4() {
    System.out.println("테스트4 수행");
  }

  @Disabled
  @Test
  @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
  void testTimeout() {
    System.out.println("Time Out Test - Start");

    // 테스트 수행에 2초가 걸렸다고 가정
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println("Time Out Test - End");
  }

  @Disabled
//  @Test // RepeatedTest 자체가 Test 어노테이션
  @RepeatedTest(10)
  void testReapeated() {
    System.out.println("반복 테스트");
  }

}
