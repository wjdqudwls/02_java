package com.mycompany.section04.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application3 {
  public static void main(String[] args) {

    List<Member> memberList = Arrays.asList(
        new Member("test01", "testName01"),
        new Member("test02", "testName022"),
        new Member("test03", "testName0333")
    );

    /* toList() : 스트림을 이용해서 새로운 불변 List 생성 */
    /* collect(Collectors.toList()) : 스트림을 이용해서 새로운 가변 List 생성 */

    // 이름만 뽑아서 새 리스트 생성
    List<String> nameList = memberList
        .stream()
//        .map( member -> member.getMemberName() )
        .map( Member::getMemberName )
//        .toList(); // toList()로 생선된 List에 add하면 에러가 발생함.
        .collect(Collectors.toList());

    System.out.println("nameList = " + nameList);

    nameList.add("testName04");
    System.out.println("nameList = " + nameList);

    /* joining() */

    String str = memberList.stream()
        .map(Member::getMemberName)
        .collect(Collectors.joining(" || ", "**", "**"));

    System.out.println("str = " + str);


    Map<Integer, Long> countByNameLength =
        memberList.stream()
            .collect(
                Collectors.groupingBy(
                    m -> m.getMemberName().length(),
                    Collectors.counting()
                )
            );
    System.out.println("countByNameLength" + countByNameLength);

  }

}
