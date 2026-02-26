package com.ohgiraffers.section01.list.dto;

public class BookDTO implements Comparable<BookDTO> {
    /* 도서 정보를 저장할 DTO 클래스를 만들어보자 */
    private int number;
    private String title;
    private String author;
    private int price;

    /*객체 복사 생성자 */
    public BookDTO(BookDTO other){
        this.title = other.title;
        this.price = other.price;
        this.number = other.number;
        this.author = other.author;


    }


    public BookDTO(){}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "BookDTO{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    public BookDTO(int number, String title, String author, int price) {
        this.number = number;
        this.title = title;
        this.author = author;
        this.price = price;



    }

    /* Comparable<T> 인터페이스
     * - 같은 인스턴스 끼리의 기본 비교 방법을 정의하는
     *    compareTo() 메서드 제공 인터페이스
     * */

    /* 가격순서 */
    @Override
    public int compareTo(BookDTO o) {
        // return this.price -o.price;

        // 이름 순서 (String의 caompareTo() 활용)
     //   return this.title.compareTo(o.title);

        // 저자 순서
        return this.author.compareTo(o.author);

    }
}
