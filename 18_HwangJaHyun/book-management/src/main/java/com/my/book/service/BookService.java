
package com.my.book.service;

import com.my.book.comparator.AscendingPrice;
import com.my.book.dto.BookDTO;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private List<BookDTO> bookList;

    public BookService(){
        bookList = new ArrayList<BookDTO>();
        readBookListFromFile();
    }

    // getter
    public List<BookDTO> getBookList(){
        return bookList;
    }

    /**
     * 책 목록에서 번호(number)가 일치하는 책을 찾아서 반환
     * @param bookNumber
     * @return BookDTO 또는 null
     */
    public BookDTO selectBookNumber(int bookNumber) {

        // 반복문을 이용해서 모든 책 인스턴스에 접근
        for (BookDTO book : bookList) {
            if (book.getNumber() == bookNumber) {
                return book; //얕은 복사
            }
        }
        return null; // 번호가 일치하는 책이 없음

        // print구문같은 거 없이 기능들만 모아둠
        // -> service로 분리
        // 비즈니스 로직
    }

    /**
     * 책 목록에 새로운 책 추가
     * 단, "제목"이 중복되는 책은 추가 X
     * @param newBook
     * @return number 또는 0
     */
    public int addBook(BookDTO newBook) {
        for (BookDTO book : bookList) {
            if(book.getTitle().equals(newBook.getTitle())){
                return 0;
            }
        }

        // 다음 번호 생성
        int nextNumber = bookList.get(bookList.size()-1).getNumber() + 1;

        // 책 정보를 목록에 추가
        newBook.setNumber(nextNumber);
        bookList.add(newBook);

        addBookToFile(newBook);

        return nextNumber;
        // return newBook.getNumber(); // 생성된 책 번호 반환
    }

    public void updateBook() {
        loadBookListFromFile(bookList);
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
            if(bookList.get(i).getNumber() == bookNumber){
                BookDTO deletedBook = bookList.remove(i);
                loadBookListFromFile(bookList);
                return deletedBook;
            }
        }
        return null;
    }

    /**
     * 책 제목 중 일부라도 keyword와 일치하는 책을 모두 반환
     * @param keyword
     * @return searchBookList
     */
    public List<BookDTO> searchBook(String keyword) {
        List<BookDTO> searchBookList = new ArrayList<>();
        for (BookDTO book : bookList) {
            if(book.getTitle().contains(keyword)){
                searchBookList.add(book); // 검색된 책 목록에 keyword 포함 책 추가
            }
        }
        return searchBookList;
    }

    /**
     *
     * @param sortingNumber
     * @return sortedBookList
     */
    public List<BookDTO> sortBookList(int sortingNumber) {
        // stream을 이용한 List 깊은 복사
        //스트림으로 변환 //새스트림생성
        List<BookDTO> sortedList = bookList.stream().map(BookDTO::new).collect(Collectors.toList());

        if(sortingNumber == 1){
            //이름 오름차순(기본정렬)
            Collections.sort(sortedList);
        }else{
            Collections.sort(sortedList, new AscendingPrice());
        }
        return sortedList;
    }

    /**
     * txt파일의 책 정보 읽어와서 booklist에 추가
     */
    private void readBookListFromFile() {
        try(BufferedReader br = new BufferedReader(new FileReader("bookList.txt"))){
            String line;
            while((line = br.readLine()) != null){
                String[] bookInfo = line.split(",");

                int number = Integer.parseInt(bookInfo[0]);
                String title = bookInfo[1];
                String author = bookInfo[2];
                int price = Integer.parseInt(bookInfo[3]);

                bookList.add(new BookDTO(number, title, author, price));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("아");
            e.printStackTrace();
        }
    }

    /**
     * txt파일에 신규 책 추가
     * @param newBook 새로 추가된 책 정보
     */
    private void addBookToFile(BookDTO newBook) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("bookList.txt", true))){
            bw.write("\n");
            bw.write(newBook.getNumber()+",");
            bw.write(newBook.getTitle()+",");
            bw.write(newBook.getAuthor()+",");
            bw.write(Integer.toString(newBook.getPrice()));

            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 최신 bookList로 txt파일 다시쓰기
     * @param bookList 최신 책 리스트
     */
    private void loadBookListFromFile(List<BookDTO> bookList) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("bookList.txt"))){
            int idx = 0;
            for(BookDTO book : this.bookList){
                if(idx == 0) idx++;
                else bw.write("\n");
                bw.write(book.getNumber()+",");
                bw.write(book.getTitle()+",");
                bw.write(book.getAuthor()+",");
                bw.write(Integer.toString(book.getPrice()));
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
