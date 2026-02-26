package org.ho.section03.references;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Application3 {
  public static void main(String[] args) {

    /* 람다식 */
    // String을 받고 Member를 return하겠다
    Function<String, Member> function1 =
        id -> new Member(id);

    Member member1 = function1.apply("user01");
    System.out.println("member1 = " + member1);

    /* 생성자 메서드 참조
     * - 메서드 명이 아닌 new를 :: 뒤에 붙임
     * */
    //String이 매개변수로 전달되고, 생성자 메서드 실행되고 Member를 반환한다.
    //자세하게 보면, 이때 Member는 객체를 생성한 인스턴스의 주소를 반환한다는 의미
    //생성자는 return이 없지만 인스턴스 주소 준다는 의미.,,
    Function<String, Member> function2 = Member::new;
    System.out.println("function2 = " + function2);

    /* 스트림 맛보기 + 메서드 참조 */
    List<String> idList = new ArrayList<>();
    idList.add("id1");
    idList.add("id2");
    idList.add("id3");

    // stream()은 idList의 값을 하나씩 꺼내온다
    // Member::new에서 id1,2,3을 전달받는것
    List<Member> memberList
        = idList.stream() // String 3개 들음
          .map(Member::new) // Member 3개 들음
        .collect(Collectors.toList()); // List로 바꿔줌

    memberList.stream().forEach(System.out::println);
    // 위아래 두 코드는 같다
    memberList.stream().forEach((mem) -> System.out.println(mem));

  }
}
