package org.ho.section04.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application3 {
  public static void main(String[] args) {

    List<Member> memberList = Arrays.asList(
        new Member("test01", "testName1"),
        new Member("test02", "testName22"),
        new Member("test03", "testName333")
    );

    /* toList() : 스트림을 이용해서 새로운 !불변! List 생성 */
    /* collect(Collectors.toList()) : 스트림을 이용해서 새로운 !가변! List 생성 */
    List<String> nameList = memberList
        .stream()
        //.map(mem -> mem.getMemberName())
        .map(Member::getMemberName)
        //.toList(); //불변
        .collect(Collectors.toList()); //가변

    //nameList.add("testName04"); //오류 발생
    System.out.println(nameList);

    /* joining()_*/
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
