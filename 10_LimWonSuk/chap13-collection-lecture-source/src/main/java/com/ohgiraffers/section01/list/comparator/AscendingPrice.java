package com.ohgiraffers.section01.list.comparator;

import com.ohgiraffers.section01.list.dto.BookDTO;

import java.util.Comparator;

public class AscendingPrice implements Comparator<BookDTO> {

    // 전달 받은 두 객체의 비교 방법을 정의해서 정렬 기준을 만듦
    // 결과 양수 -> 뒤로
    // 결과 양수 -> 앞으로

    @Override
    public int compare(BookDTO o1, BookDTO o2) {
        return o1.getPrice() - o2.getPrice();
       // return o2.getPrice() - o1.getPrice(); // 이러면 내림차순
    }
}
