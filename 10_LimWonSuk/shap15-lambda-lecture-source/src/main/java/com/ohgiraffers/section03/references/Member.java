package com.ohgiraffers.section03.references;

public class Member {

    private String memberId;

    public Member(String memberId) { // 실행시 단 1회시행됨 메서드 참조
        this.memberId = memberId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                '}';
    }
}