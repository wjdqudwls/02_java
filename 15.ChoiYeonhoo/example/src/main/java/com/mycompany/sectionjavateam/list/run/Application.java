package com.mycompany.sectionjavateam.list.run;

import com.mycompany.sectionjavateam.list.dto.BookDTO;
import com.mycompany.sectionjavateam.list.service.BookService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Application {

  private Scanner sc = new Scanner(System.in);
  private BookService bookService = new BookService();

  public static void main(String[] args) {
    new Application().run();
  }

  public void run() {

    int input = 0;

    do {

      /* 추가할만한 기능 :
       * 입력 기능 개선 : 가격 음수 방지
       *
       * */
      System.out.println("\n======== 도서 관리 프로그램 ========\n");

      System.out.println("1. 모든 도서 목록 조회");
      System.out.println("2. 도서 상세 조회");
      System.out.println("3. 도서 추가");
      System.out.println("4. 도서 수정");
      System.out.println("5. 도서 제거");
      System.out.println("6. 도서 검색");
      System.out.println("7. 도서 정렬");
      System.out.println("0. 프로그램 종료 ");

      try {
        System.out.print("번호 선택 >> ");
        input = sc.nextInt();
        sc.nextLine(); // 입력 버퍼 개행 문자 제거
        switch (input) {
          case 1:
            selectAll();
            break;

          case 2:
            selectBookNumber();
            break;

          case 3:
            addBook();
            break;

          case 4:
            updateBook();
            break;

          case 5:
            deleteBook();
            break;

          case 6:
            searchBook();
            break;

          case 7:
            sortBookList();
            break;

          case 0:
            System.out.println(" 프로그램을 종료합니다.");
            break;

          default:
            System.out.println("@@@@@@ 메뉴 목록에 존재하는 번호를 입력하세요. @@@@@");
        }
      } catch (InputMismatchException e) {
        System.out.println("###### 입력 형식이 잘못 되었습니다. ######");
        sc.nextLine(); // 입력 버퍼에 남은 잘못된 문자열을 제거
        input = -1; // 첫 반복 입력 오류 시 비정상 종료 막기
      } catch (Exception e) { //나머지 예외 발생 처리
        System.out.println("##### 예외 발생, 관리자에게 문의하세요 ##### ");
        e.printStackTrace();
      }

    }
    while (input != 0);

  }

  /* 1. 모든 도서 목록 조회 */
  /* 5개씩 끊어서 보고, 이전, 다음페이지, 원하는 페이지 넘어가기 추가
   * - 첫페이지, 마지막 페이지에서 더 넘어가지 않게 예외처리 필요
   * - 어디서 5개씩 끊는게 좋은지? 1.  다 불러오고 5개씩 끊어서 보여줘야하나?, 2. 5개씩 끊어서 불러와야하나? ?
   *  여기서 처리하자 */
  private void selectAll() {
    System.out.println("=== 도서 목록 조회 ===");
    List<BookDTO> books = bookService.getBookList();

    // 페이지 개수 계산하기
    int bookTotalCount = books.size();
    int bookPerPage = 5;
    // 37개면 5개씩 하면 8개 필요
    // 35개면 7개
    // 전체 / 5 의 나머지가 0 이면 그대로, 나머지 있으면 + 1 페이지
    int totalPage = ((bookTotalCount / bookPerPage) % bookPerPage == 0 ? (bookTotalCount / bookPerPage) : (bookTotalCount / bookPerPage) + 1);

    int currentPage = 1; // 현재 페이지, 초기 페이지

    // 페이지 이동 하기

    // 목록 나가기 전까지는 계속 목록 보여줘야하니까 loop
    // 현재 페이지가 어디인지 상단에 표시 "*** 현재 페이지 : 2 Page ***"
    // 이전페이지(1), 다음페이지(2),원하는 페이지 이동(3)(최대 페이지 값도 같이 출력, 음수 못넣도록),  뒤로가기(0)(메인 목록으로) 입력할 수 있도록 함.
    // -> 이러면 while문 안에 표시해야 현재 페이지가 따라서 변하겠네

    // 나갔다 들어와도 이전에 있던 페이지로 바로 가게? 아니면 그냥 초기화?
    // 별다른 처리 안하면 current page 값이 마지막에서 유지되서 나갔던 페이지로 돌아올듯, 초기화가 좋을거 같은데? 일단 확인부터

    // 첫페이지에서는 이전페이지로 못가도록
    // 마지막페이지에서는 다음페이지로 못가도록
    // 어떻게 할까. 어짜피 첫페이지, 마지막 페이지기 어딘줄 아니까. if문으로 하면 될 듯?
    while (true) {
      break;
    }

    for (BookDTO book : books) {
      // 해당 페이지 내용 출력하기

      // 현재 페이지에 해당하는 자료 개수 끌어오기, 스트림으로 출력하면 될듯(원본 훼손 없어야하니까)
      // 만약 2페이지라면 1~5번은 건너뛰고, 6~10번만 끌어오기
      // -> ((출력할 페이지 번호)-1) * 5 + 1 부터 출력해서 bookPerPage 만큼
      // index로 뽑아와야하니까, 개수 잘 맞춰야 할듯? 확인 필요
      // stream에 출력할때, db limit같은 기능 있었으니까 그걸로

      // 마지막 페이지에 개수가 5개보다 작으면 어떻게 되지? 그냥 하면 해당 index가 없어서 에러뜰거고, 남은 갯수 알아야 할듯?
      // 마지막 페이지 표현할 개수 = bookTotalCount % bookPerPage 만큼 하면 되겠네 37개면 5개씩 표현했을 때, 마지막 페이지에는 37 % 5 = 2 개
      System.out.println(book);
    }
  }

  /**
   * 2. 도서 상세 조회(도서 번호)
   *
   * @throws InputMismatchException
   */
  private void selectBookNumber() throws InputMismatchException {
    System.out.println("\n*** 도서 상세 조회(도서 번호) ***\n");
    System.out.print("상세 조회할 도서 번호 입력 : ");
    int bookNumber = sc.nextInt();

    // 서비스 호출
    BookDTO book = bookService.selectBookNumber(bookNumber);

    if (book == null) {
      System.out.println("@@@ 일치하는 번호의 책이 없습니다. @@@");
      return;
    }

    System.out.println("책 번호: " + book.getNumber());
    System.out.println("책 제목: " + book.getTitle());
    System.out.println("책 저자: " + book.getAuthor());
    System.out.println("책 가격: " + book.getPrice() + "원");
  }

  /**
   * 3. 도서 추가
   */
  private void addBook() {
    System.out.print("\n*** 도서 추가 ***\n");

    System.out.print("책 제목 입력 : ");
    String title = sc.nextLine();

    System.out.print("책 저자 입력 : ");
    String author = sc.nextLine();

    System.out.print("책 가격 입력 : ");
    int price = sc.nextInt();
    sc.nextLine();

    // DTO : Data Transfer Object : 계층간(클래스간) 데이터 전달 목적의 객체
    // BookDTO 객체 생성 및 값 대입
    // method(a,b,c,d,e) : 이런식으로 parameter가 많으면 좋지 않음
    BookDTO book = new BookDTO();
    book.setTitle(title);
    book.setAuthor(author);
    book.setPrice(price);

    // 서비스 호출
    int bookNumber = bookService.addBook(book);

    if (bookNumber == 0) {
      System.out.println("@@@ 책 추가에 실패했습니다. @@@");
      return;
    }

    System.out.println(bookNumber + "번 책이 추가 되었습니다.");
  }

  /* 추가할만한 기능 : 도서 수정 기능 BookService로 통합
  /* 4. 도서 수정 */
  private void updateBook() {
    System.out.println("\n***** 도서 수정 *****\n");
    // 1. 책 번호로 수정할 책이 있는지 검색
    //  -> 없으면 메서드 종료

    System.out.print("수정할 도서 번호 입력 : ");
    int bookNumber = sc.nextInt();
    sc.nextLine();

    // 서비스 호출
    BookDTO book = bookService.selectBookNumber(bookNumber);

    if (book == null) {
      System.out.println("@@@ 일치하는 번호의 책이 없습니다. @@@");
      return;

    }
    // 2. 해당 책의 제목,저자,가격을 수정
    System.out.print("수정할 책 제목 : ");
    String updateTitle = sc.nextLine();

    System.out.print("수정할 책 저자 : ");
    String updateAuthor = sc.nextLine();

    System.out.print("수정할 책 가격 : ");
    int updatePrice = sc.nextInt();
    sc.nextLine();

    //
    // book은 bookService의 해당 번호의 책 정보에 해당하는 주소를 저장함 (얕은 복사)
    // 그러므로 해당 내용을 수정하면 원본도 수정이 된다.
    book.setTitle(updateTitle);
    book.setAuthor(updateAuthor);
    book.setPrice(updatePrice);

    System.out.println("책 정보가 수정 되었습니다.");

  }

  /**
   * 5. 도서 제거
   */
  private void deleteBook() {
    System.out.print("\n*** 도서 제거 ***\n");

    System.out.print("제거할 도서 번호 입력 : ");
    int bookNumber = sc.nextInt();
    sc.nextLine();

    // 서비스 호출
    BookDTO deletedBook = bookService.deleteBook(bookNumber);

    if (deletedBook == null) {
      System.out.println("@@@ 일치하는 번호의 책이 없습니다. @@@");
      return;
    }

    System.out.println(deletedBook.getTitle() + "이/가 제거 되었습니다.");

  }

  /**
   * 6. 도서 검색
   */
  private void searchBook() {
    System.out.print("\n*** 도서 검색(제목 부분 일치 검색) ***\n");

    System.out.print("검색할 책 제목 입력 : ");
    String keyword = sc.nextLine();

    // 서비스 호출
    List<BookDTO> searchBookList = bookService.searchBook(keyword);

    if (searchBookList == null || searchBookList.isEmpty()) {
      System.out.println("검색 결과가 없습니다.");
      return;
    }

    for (BookDTO book : searchBookList) {
      System.out.println(book);
    }
  }

  /**
   * 7. 도서 정렬 (원본은 유지한 형태) -> 깊은 복사 활용
   */
  private void sortBookList() {
    System.out.print("\n*** 도서 정렬 목록 조회 ***\n");

    System.out.println("1. 도서명 오름차순");
    System.out.println("2. 가격 오름차순");
    int sortingNumber = sc.nextInt();
    sc.nextLine();

    // 서비스 구현
    List<BookDTO> books = bookService.sortBookList(sortingNumber);

    for (BookDTO book : books) {
      System.out.println(book);
    }


  }


}
