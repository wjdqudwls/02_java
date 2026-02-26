package com.mycompany.section03.lifecycle;

import org.junit.jupiter.api.*;

public class LifeCycleAnnotationTests {

  /* 테스트 수행 전/후에 동작하는 어노테이션 확인 */

  /* 테스트 수행 전 필요한 자원을 설정하는 역할로 주로 사용 */
  @BeforeAll
  static void setup(){ // 테스트코드 beforeAll 함수명은 주로 setup이라고 함
    System.out.println("####### BeforeAll 동작 #######");
  }

  /* 테스트 수행 후, 사용한 자원을 반환 하는 역할로 많이 사용 */
  @AfterAll
  static void afterAll(){ // afterAll 또는 closed 라는 이름 많이 씀
    System.out.println("!!!!!!! AfterAll 수행 !!!!!!!!");
  }

  /* 각 테스트가 수행 되기 전 */
  @BeforeEach
  void beforeEach(){
    System.out.println("@@@@@ BeforeEach 동작 @@@@@");
  }

  /* 각 테스트가 수행 된 후 */
  @AfterEach
  void afterEach(){
    System.out.println("$$$$$ afterEach 동작 $$$$$$");
  }

  @Test
  void test1(){
    System.out.println("테스트 코드 1");
  }
  @Test
  void test2(){
    System.out.println("테스트 코드 2");
  }

}
