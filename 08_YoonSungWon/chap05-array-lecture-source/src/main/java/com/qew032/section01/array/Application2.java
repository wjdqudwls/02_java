package com.qew032.section01.array;

public class Application2 {
  public static void main(String[] args) {

    /* 배열 선언 및 할당 */
    int[] arr = new int[4];

    /* JVM 메모리 영역 중 heap은 비어있는 상태로 존재할 수 없다
     * -> 할당 시 각 자료형의 기본 값으로 초기화 되어있음
     *
     * 자료형 별 기본 값
     * - 정수 / 실수 -> 0, 0L, 0.0f, 0.0
     * - char -> '\u0000' (유니코드 0번)
     * - boolean -> false
     * - 참조형(ex. String) -> null
     *
     * */

    for (int num : arr) {
      System.out.println("num = " + num);
    }

  }
}
