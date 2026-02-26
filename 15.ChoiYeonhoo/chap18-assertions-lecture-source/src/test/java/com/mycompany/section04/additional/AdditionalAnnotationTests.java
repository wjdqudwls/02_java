package com.mycompany.section04.additional;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;


/* @Order 어노테이션 기능 활설화를 위해 클래스 레벨에 추가하는 구문 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdditionalAnnotationTests {
//  @Disabled // 비활성화

  @Order(4) // 테스트 실행 순서
  @Test
  void test1(){
    System.out.println("test1 수행");
  }

  @Order(3) // 테스트 실행 순서
  @Test
  void test2(){
    System.out.println("test2 수행");
  }

  @Order(2) // 테스트 실행 순서
  @Test
  void test3(){
    System.out.println("test3 수행");
  }
  @Order(1) // 테스트 실행 순서
  @Test
  void test4(){
    System.out.println("test4 수행");
  }

  @Disabled
  @Test
  @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
  void testTimeOut(){
    System.out.println("Time Out Test - Start");

    try {
      Thread.sleep(950);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println("Time Out Test - End");
  }

  @Disabled
  @RepeatedTest(10) // 테스트 10회 반복
  void testRepeated(){
    System.out.println("반복테스트");
  }
}
