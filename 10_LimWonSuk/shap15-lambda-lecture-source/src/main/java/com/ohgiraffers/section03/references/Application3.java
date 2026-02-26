package com.ohgiraffers.section03.references;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Application3 {
    public static void main(String[] args) {

            /* 람다식 */
        Function<String, Member> function1
                = (name) -> {return new Member(name); };
        
        Member member1 = function1.apply("user01");
        System.out.println("member1 = " + member1);

        /* 생성자 메서드 참조
        * - 메서드 명이 아닌 new를 :: 뒤에 붙임
        * */
        Function<String, Member> function2
                = Member::new; // = Member의 new의 주소가 반환됨

        Member member2 = function2.apply("user02");
        System.out.println("member2 = " + member2);

        /* 스트림 맛보기 + 메서드 참조 */
        List<String> idList = new ArrayList<>();
        idList.add("id1");
        idList.add("id2");
        idList.add("id3");

        List<Member> memberList
                = idList.stream().map(Member::new).collect(Collectors.toList());
        // Member 값 3개가 만들어진 stream이 만들어진다

        memberList.stream().forEach(System.out::println);
    }
}
