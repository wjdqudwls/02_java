package com.beyond.section01.list.dto;

import java.io.Serializable;

public class BookDTO implements Comparable<BookDTO>, Serializable {
  /* 도서 정보를 저장할 DTO 클래스를 만들어보자 */
  private int number;
  private String title;
  private String author;
  private int price;

  public BookDTO() {

  }

  public BookDTO(int number, String title, String author, int price) {
    this.number = number;
    this.title = title;
    this.author = author;
    this.price = price;
  }

  public BookDTO(BookDTO other) {
    this.number = other.number;
    this.title = other.title;
    this.author = other.author;
    this.price = other.price;
  }

  public int getNumber() {
    return number;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getPrice() {
    return price;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  /* toString 오버라이딩 */
  @Override
  public String toString() {
    return "BookDTO [number=" + number + ", title=" + title + ", author=" + author + ", price=" + price + "]";
  }

  /* Comparable<T> 인터페이스
  * - 같은 인스턴스 끼리의 기본 비교 방법을 정의하는
  *   compareTo() 메서드 제공 인터페이스
  * */

  // 가격 순서
  @Override
  public int compareTo(BookDTO o) {
    // 가격 순서
    // return this.price - o.price;

    // 이름 순서 (String의 compareTo() 활용)
    return this.title.compareTo(o.title);
  }
}