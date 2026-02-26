package com.beyond.section01.jupiter;

public class Person {
  private String firstName;
  private String lastName;

  public Person(String str1, String str2) {
    this.firstName = str1;
    this.lastName = str2;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }





}
