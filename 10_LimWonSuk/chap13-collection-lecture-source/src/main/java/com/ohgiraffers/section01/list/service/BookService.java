package com.ohgiraffers.section01.list.service;

import com.ohgiraffers.section01.list.comparator.AscendingPrice;
import com.ohgiraffers.section01.list.dto.BookDTO;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private List<BookDTO> bookList;

    public BookService() {
        bookList = new ArrayList<>();

        /* 도서 정보 추가 */
        bookList.add(new BookDTO(1, "홍길동전", "허균", 50000));
        bookList.add(new BookDTO(2, "목민심서", "정약용", 30000));
        bookList.add(new BookDTO(3, "동의보감", "허준", 40000));
        bookList.add(new BookDTO(4, "삼국사기", "김부식", 46000));
        bookList.add(new BookDTO(5, "삼국유사", "일연", 58000));

    }

    // getter
    public List<BookDTO> getBookList() {
        return bookList;
    }


    /**
     * 책 목록에서 번호 (Number)가 일치하는 책을 찾아서 반환
     *
     * @param bookNumber
     * @return
     */

    public BookDTO selectBookNumber(int bookNumber) {
       /*  하나씩 훑어볼려면 for문 (반복문)을 이용해서
             모든 책 인스턴스에 접근
            * */
        for (BookDTO book : bookList) {
            if (book.getNumber() == bookNumber) return book;

        }
        return null; // 번호가 일치하는 책이 없음
    }


    /**
     * 책 제목에 새로운 책 추가
     * 단, "제목"이 중복되는 책은 추가 x
     * 반환되는 number은 마지막 number +1
     *
     * @param newbook
     * @return
     */
    public int addBook(BookDTO newbook) {

        // 중복 체크
        for (BookDTO book : bookList) {
            if (book.getTitle().equals(newbook.getTitle())) // 중복인 경우
                return 0;
        }


        // 다음 번호 생성
        int nextNumber = bookList.get(bookList.size() - 1).getNumber() + 1;

        // 책 정보를 목록에 추가
        newbook.setNumber(nextNumber);
        bookList.add(newbook);

        return newbook.getNumber();
    }

    /* 4. 도서 수정
     *
     * */
    private void updateBook() {
        System.out.println("\n========= 도서 수정==========\n");


    }


    /**
     * 도서 목록에서 번호가 일치하는 책 제거
     *
     * @param bookNumber
     * @return
     */

    public BookDTO deleteBook(int bookNumber) {
         /*  하나씩 훑어볼려면 for문 (반복문)을 이용해서
             모든 책 인스턴스에 접근
             * -> 똑같은 번호의 책을 목록에서 제거 후 반환
            * */
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getNumber() == bookNumber) {
                return bookList.remove(i);
            }

        }
        return null;
    }

    /**
     * 채 제목중 일부라도 keyword와 일치하는 책을 모두 반환
     *
     * @param keyword
     * @return
     */
    public List<BookDTO> searchBook(String keyword) {
        List<BookDTO> searchBookList = new ArrayList<>();

        for (BookDTO book : bookList) {
            if (book.getTitle().contains(keyword)) {
                searchBookList.add(book); // 검색된 책 목록에 keyword 포함 책 추가
            }
        }

        return searchBookList;
    }

    /**
     * List 복사본을 만들어서 정렬 후 반환
     * @param sortingNumber
     * @return
     */
    public List<BookDTO> sortBookList(int sortingNumber) {

        // Collections.sort() -> 원본 정렬

        // 스트림을 이용한 List 깊은 복사
        List<BookDTO> sortedList
                = bookList.stream().map(BookDTO::new).collect(Collectors.toList());
        if(sortingNumber == 1 ){
        Collections.sort(sortedList);
    }else { // 가격 오름 차순 (추가 정렬 기준)
            Collections.sort(sortedList, new AscendingPrice());

        }
        return sortedList;
    }

}
