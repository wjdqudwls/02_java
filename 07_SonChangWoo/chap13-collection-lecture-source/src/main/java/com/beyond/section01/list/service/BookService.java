package com.beyond.section01.list.service;

import com.beyond.section01.list.comparator.AscendingPrice;
import com.beyond.section01.list.dto.BookDTO;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {
  private List<BookDTO> bookList;
  private final String FILE_PATH = "books.dat"; // 저장할 파일명

  public BookService() {
    loadBooksFromFile(); // 서비스 객체 생성 시 파일에서 데이터를 불러옴
  }

  private void loadBooksFromFile() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
      // 파일에서 List<BookDTO> 객체를 역직렬화하여 불러옵니다.
      bookList = (List<BookDTO>) ois.readObject();
      System.out.println("데이터 로드 완료: " + bookList.size() + "권");
    } catch (FileNotFoundException e) {
      // 파일이 없으면 (최초 실행) 새로운 리스트를 생성합니다.
      bookList = new ArrayList<>();
      System.out.println("새 도서 목록을 생성합니다.");
    } catch (Exception e) {
      // 기타 예외 처리 (e.g., ClassNotFoundException)
      e.printStackTrace();

      // 파일 로딩 실패 시 프로그램이 정상적으로 동작하도록 보장하기 위해
      // -> 데이터를 불러오지 못하더라도 빈 목록이라도 생성하여 bookList 변수를 유효한 상태로 유지하기 위한 구문
      bookList = new ArrayList<>();
    }
  }

  private void saveBooksToFile() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
      // 현재 메모리에 있는 bookList 전체를 파일에 직렬화하여 저장
      oos.writeObject(bookList);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


/*  public BookService() {
    bookList = new ArrayList<>();
    *//* 도서 정보 추가 *//*
    bookList.add(new BookDTO(1, "홍길동전", "허균", 50000));
    bookList.add(new BookDTO(2, "목민심서", "정약용", 30000));
    bookList.add(new BookDTO(3, "동의보감", "허준", 40000));
    bookList.add(new BookDTO(4, "삼국사기", "김부식", 46000));
    bookList.add(new BookDTO(5, "삼국유사", "일연", 58000));
  }*/

  // getter
  public List<BookDTO> getBooklist() {
    return bookList;
  }


/*
* 책 목록에서 번호(number)가 일치하는 책을 찾아서 반환
* @param bookNumber
* @return BookDTO 또는 null
* */
  public BookDTO selectBookNumber(int bookNumber) {

    // 반복문을 이용해서 모든 책 인스턴스에 접근
    for (BookDTO book : bookList) {
      if (book.getNumber() == bookNumber) {
        return book;
      }
    }

    return null; // 번호가 일치하는 책이 없음
  }

  /**
   * * 책 목록에 새로운 책 추가
   * * 단, "제목"이 중복되는 책은 추가 X
   * * 빈환되는 number는 마지막 number + 1
   * @param newBook
   * @return number 또는 0
   */
  public int addBook(BookDTO newBook) {

    for(BookDTO book : bookList) {
      if (book.getTitle().equals(newBook.getTitle())) {
        return 0;
      }
    }

    // 다음 번호 생성
    int nextNumber;
    if (bookList.isEmpty()) { // 리스트가 비어있으면 1부터 시작
      nextNumber = 1;
    } else { // 아니면 마지막 번호 + 1
      nextNumber = bookList.get(bookList.size() - 1).getNumber() + 1;
    }

    // 책 정보를 목록에 추가
    newBook.setNumber(nextNumber);
    bookList.add(newBook);

    saveBooksToFile();

    return nextNumber;

  }

  /**
   * 도서 목록에서 번호가 일치하는 책 제거
   * @param bookNumber
   * @return 제거된 BookDTO 또는 null
   */
  public BookDTO deleteBook(int bookNumber) {
    // 반복문을 이용해서 모든 책 인스턴스에 접근
    // -> 똑같은 번호의 책을 목록에서 제거 후 반환
    for (int i = 0; i < bookList.size(); i++) {
      if (bookList.get(i).getNumber() == bookNumber) {
        BookDTO deletedBook = bookList.remove(i);
        saveBooksToFile(); // 책이 실제로 제거된 후 저장
        return deletedBook;
      }
    }



    return null;
  }

  public void updateBook() {

    saveBooksToFile();
  }

  /**
   * 책 제목 중 일부라도 keyword와 일치하는 책을 모두 반환
   * @param keyword
   * @return searchBookList
   */
  public List<BookDTO> searchBook(String keyword) {
    List<BookDTO> searchBookList = new ArrayList<>();
    for (BookDTO book : bookList) {
      // 제목에 keyword가 포함되어 있으면 true
      if (book.getTitle().contains(keyword)) {
        searchBookList.add(book); // 검색된 책 목록에 keyword 포함 책 추가
      }
    }

    return searchBookList;
  }

  /**
   * List 복사본을 만들어서 정렬 후 반환
   * @param sortingNumber
   * @return sortedBookList
   */
  public List<BookDTO> sortBookList(int sortingNumber) {

    // Collection.sort() -> 원본 정렬

    // 스트림을 이용한 List 깊은 복사
    List<BookDTO> sortedList = bookList.stream().map(BookDTO::new).collect(Collectors.toList());

    if (sortingNumber == 1) { // 이름 오름차순(기본 정렬)
      Collections.sort(sortedList);
    } else { // 가격 오름차순(추가 정렬 기준)
      Collections.sort(sortedList, new AscendingPrice());
    }

    return sortedList;
  }
}
