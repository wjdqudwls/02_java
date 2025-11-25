package com.qew032.section03.dto;

// DTO(Data Transfer Object, 데이터 전달 객체)
// - 데이터를 묶어서 전달하는 용도의 객체
// - 추상화된 필드 o
// - getter/setter 외에 다른 메서드가 없음
public class MemberDTO {

    private int number;				    	//회원번호
    private String name;				        //회원명
    private int age;					            //나이
    private char gender;				        //성별
    private double height;			  	    //키
    private double weight;			  	    //몸무게
    private boolean isActivated;		    //회원탈퇴여부(활성화여부)


    /* 필드 간접 접근을 위한 getter(접근자), setter(설정자) */

    public  int getNumber(){
        return  number;
    }

    public  void setNumber(int number){
        this.number = number;
    }

    public String  getName() {
        return name;
    }

    public void  setName(String name) {
        this.name = name;;
    }

}
