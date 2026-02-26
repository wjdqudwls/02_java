/*
package com.ohgiraffers.section04.terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application3 {
    public static void main(String[] args) {
        List<Member> memberList = Arrays.asList(
                new Member("test01", "testName01"),
                new Member("test02", "testName02"),
                new Member("test03", "testName033")
        );

        */
/* toList() : 스트림을 이용해서 새로운 불변 List 생성 *//*


        */
/* collcect(Collectors.toList))
        *           : 스트림을 이용해서 새로운 가변 List 생성*//*

        List<String> nameList = memberList
                .stream()
                //.map( member -> member.getMemberName() )
                .map(Member::getMemberName)
               // .toList(); // 불변
                       //.collect()

        System.out.println(nameList);

        nameList.add("testName04");


        String str = memberList.stream()
                .map(Member::getMemberName)
                .collect(Collectors.joining(" || ", "**", "**"));

        System.out.println("str = " + str);


    }
    public static void main(String[] args) {
        */
/* 스트림의 병렬 처리에 대해 이해할 수 있다. *//*

        List<String> list = new ArrayList<>(
                Arrays.asList("java", "mariadb", "html", "css", "mybatis")
        );

        */
/* 모든 작업은 기본적으로 main 스레드에서 일어난다. *//*

        System.out.println("for each =================");
        for(String s : list) {
            print(s);
        }

        System.out.println("normal stream ==============");
        list.stream().forEach(Application2::print);

        */
/* 병렬 스트림을 활용하면 처리해야할 데이터 요소가 많을 경우
         * 효율적으로 처리할 수 있는 장점이 있다. *//*

        System.out.println("parallel stream ============");
        list.parallelStream().forEach(Application2::print);
        list.parallelStream().forEach(Application2::print);
    }

    private static void print(String str) {
        System.out.println(str + " : " + Thread.currentThread().getName());
    }
    }
*/
package com.ohgiraffers.section04.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application3 {
    public static void main(String[] args) {
        List<Member> memberList = Arrays.asList(
                new Member("test01", "testName01"),
                new Member("test02", "testName02"),
                new Member("test03", "testName03")
        );

        /* toList() : 스트림을 이용해서 새로운 불변 List 생성 */

    /* collect(Collectors.toList())
      : 스트림을 이용해서 새로운 가변 List 생성 */
        List<String> nameList = memberList
                .stream()
                //.map( member -> member.getMemberName() )
                .map(Member::getMemberName)
                //.toList();
                .collect(Collectors.toList());

        System.out.println(nameList);

        nameList.add("testName04");
        System.out.println(nameList);


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