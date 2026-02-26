package org.ho.section02.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Application1 {
  public static void main(String[] args) {
    /* Set : 순서 유지 X, 중복 데이터 X ( 중복 제거 )
     *
     * HashSet : hashCode를 이용해서 검색 속도를 증가시킨 Set
     * - 사용 조건 : Set에 저장되는 인스턴스는 equals(), hashCode() 오버라이딩 필수
     * */

    Set<String> set = new HashSet<>();

    // 1) boolean add(E e) : 요소 추가
    set.add("java");
    set.add("mariadb");
    set.add("git");
    set.add("github");
    set.add("linux");
    set.add("linux"); // 중복 제거
    set.add(new String("linux")); // 중복 제거

    System.out.println(set); // 중복 제거 + 순서 유지 X

    // 2) int size() : set에 저장된 요소의 개수
    System.out.println("set.size() = " + set.size());

    // 3) boolean contains(E e) : 전달된 요소가 set에 있으면 true
    System.out.println("set.contains(\"java\") = " + set.contains("java"));

    // 4) boolean remove(E e) : 같은 요소를 찾아서 삭제 성공하면 true
    System.out.println("\n" + set);
    System.out.println("set.remove(\"git\") = " + set.remove("git"));
    System.out.println(set);

    System.out.println("----------------------------------------");

    /* Set에 저장된 데이터 얻어오기
     * - Set은 기본적으로 특정 요소 1개 얻어오기가 불가능
     *  -> Set 데이터 순회 방법을 이용(순차 접근)
     * */

    /* 1. Set -> 배열로 변경 */
    Object[] arr = set.toArray();
    for (int i = 0; i < arr.length; i++) {
      System.out.println("arr[" + i + "] = " + arr[i]);
    }

    /* 2. Iterable의 iterator() 메서드(반복자) */

    // set에 저장된 요소를 반복하면서 순회는 인스턴스를 생성 후 반환
    Iterator<String> it = set.iterator();
    while (it.hasNext()) { //다음 반복 순회 할 요소가 있으면 true
      System.out.println(it.next());

    }

    /* 3. 향상된 for문 */
    for (String s : set) {
      System.out.println("s = " + s);
    }
  }
}
