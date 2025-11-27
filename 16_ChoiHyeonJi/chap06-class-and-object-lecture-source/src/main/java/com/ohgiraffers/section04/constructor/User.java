package com.ohgiraffers.section04.constructor;

import java.util.Date;

public class User {
    /* 필드 */
    private String id;
    private String pwd;
    private String name;
    private Date enrollDate; //가입일
  
    /* 메서드 */

  
   /* 생성자 선언부
   * [생성자 작성법]  매개변수는 [] 선택적으로 생략 가능.
   * public 클래스명 ([매개변수]) {
   *    수행할 코드;
   * }
   * */

  /* 기본 생성자
  * - 매개 변수가 없는 생성자
  * - 클래스 내에 생성자가 1개도 없다면 (==0개)
  * 컴파일러에 의해서 자동으로 추가된다. */
    public User(){
      System.out.println("User 기본 생성자 호출됨");
    }



  /* 2. 매개변수 있는 생성자 */
  public User(String id, String pwd, String name) {
    this.id = id;
    this.pwd = pwd;
    this.name = name;
    System.out.println("User 생성과 동시에 id, pwd, name 초기화");
  }


  /* this() 생성자 이용한 코드 중복 제거 */
  public User(String id, String pwd, String name, Date enrollDate) {

    this(id, pwd, name); // 같은 클래스 내 다른 생성자 호출 시 this() 작성
    this.enrollDate = enrollDate;
    System.out.println("User 생성과 동시에 id, pwd, name 초기화");
  }

  /* 목차. 4. 복사 생성자 */
  public User(User otherUser) {
    this(otherUser.id, otherUser.pwd, otherUser.name, otherUser.enrollDate);
  }

  /* 메서드 선언부 */

}
