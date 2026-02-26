package com.mycompany.sectionjavateam.list.comparator;

import com.mycompany.sectionjavateam.list.dto.BookDTO;

import java.util.Comparator;

public class AscendingPrice implements Comparator<BookDTO> {

  // 전달 받은 두 객체의 비교 방법읠 정의해서 정렬
  // 결과가 양수 -> 뒤로
  // 결과가 양수 X -> 앞으로
  @Override
  public int compare(BookDTO o1, BookDTO o2) {
    return o1.getPrice() - o2.getPrice(); // 오름차순
    //return o2.getPrice() - o1.getPrice(); // 내림차순
  }
}
