package com.my.section03.filterstream;

/* java.io.Serializable 마커 인터페이스
* - 직렬화의 대상임을 명시하는 인터페이스
* - 따로 구현할 추상 메서드가 없음
* */
public class Member implements java.io.Serializable {

  private String id;
  private String pwd;
  private int age;
  private char gender;

  public Member(String id, String pwd, int age, char gender) {
    this.id = id;
    this.pwd = pwd;
    this.age = age;
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "Member{" +
        "id='" + id + '\'' +
        ", pwd='" + pwd + '\'' +
        ", age=" + age +
        ", gender=" + gender +
        '}';
  }
}
