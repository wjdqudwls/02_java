package com.ohgiraffers.section02.encapsulation.problem3;

public class Application { // 객체의 필드에 직접 접근을 하면 발생하는 유지보수 문제점
  public static void main(String[] args) {
    Monster monster1 = new Monster();
    monster1.setInfo("드라큘라"); // 간접

    monster1.setHp(200); // Monster 객체의 필드에 직접 접근

    System.out.println("monster1 name : " + monster1.getInfo()); //간접
    System.out.println("monster1 hp : " + monster1.getHp());

    Monster monster2 = new Monster();
    monster2.setInfo("프랑켄슈타인");

    monster2.setHp(300); //Monster 객체의 필드에 간접 접근 간접적인 전달
    System.out.println("monster2 name : " + monster2.getInfo());
    System.out.println("monster2 hp : " + monster2.getHp());

    Monster monster3 = new Monster();
    monster3.setInfo("미이라");

    monster3.setHp(-400);
    System.out.println("monster3 name : " + monster3.getInfo());
    System.out.println("monster3 hp : " + monster3.getHp());


  }
}
