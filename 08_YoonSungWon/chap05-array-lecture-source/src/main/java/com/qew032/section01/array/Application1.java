package com.qew032.section01.array;

public class Application1 {

    public static void main(String[] args) {

        /* 배열 (참조형 변수) 선언 */
        int[] arr1;     // int[] 주소를 저장할 참조형 변수 선언
        int arr2[];     // arr1, arr2 모두 int[] 참조형 변수 선언 방법

        /* 배열 할당 */
        arr1 = new int[5];    // heap에 생성된 int[]의 주소를 arr1에 대입
        // == arr1이 생성된 int[]를 참조함
        // new : heap영역에 새로 할당 후 주소 반환
        // int[5] : int형 변수 5개를 생성 --> 5개의 묶음 == int[] 자료형
        //                                  각각 0부터 시작하는 index 번호가 부여

        /* 배열 요소에 접근하여 값 대입하기 */
        arr1[0] = 10;       // 인덱스를 활용해서 요소별로 접근 가능
        arr1[1] = 20;
        arr1[2] = 30;
        arr1[3] = 40;
        arr1[4] = 50;

        /* 배열 요소에 접근하여 값 출력하기 (배열 +  for문) */
        for (int i = 0; i < arr1.length; i++) {

            System.out.println("arr1[" + i + "] = " + arr1[i]);

        }
        System.out.println("===== 향상된 for문 =====");
        /* 향상된 for문
         *  -
         * [작성법]
         * for (배열 요소를 저장할 변수선언 : 배열명) {
         *   반복 수행할 코드
         * }
         *
         * - 작성된 배열의 첫번째(0) 요소 부터
         *    마지막 요소(배열.length - 1)까지
         *    하나씩 순차적으로 변수에 저장하는 반복문
         *
         * */

        for (int num : arr1) {
            System.out.println("num = " + num);
        }

        /* 향상된 for문 + 배열 + 살짝 응용 */
        // arr1에 저장된 모든 배열 요소의 합 구하기

        //  일반
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum += arr1[i];
        }
        System.out.println("sum = " + sum);

        // 향상
        int sum1 = 0;
        for (int num1 : arr1) {
            sum1 += num1;
        }
        System.out.println("sum1 = " + sum1);

        /* 참조형 변수에 저장된 "주소" 확인 하기
         * - [참조형 변수(Reference Variable)]
         * - new 연산자에 의해서 할당된 공간의 주소를 저장하기 위한 변수
         *
         * - 참조형 변수는 주소를 저장하고 있다는 것을 꼭 기억하자
         * */

        int[] iarr = new int[5];
        double[] darr = new double[10];

        //   출력 결과 : [자료형 @ 해시코드
        System.out.println("iarr = " + iarr);
        System.out.println("darr = " + darr);


        /* hashcode() : 객체(배열)의 주소 값을 10진수로 변환하여 반환하는 고유한 정수값
         *   생성한 객체(배열)의 고유한 정수값을 반환하는 매서드
         * */
        System.out.println("iarr.hashCode() : " + iarr.hashCode());
        System.out.println("darr.hashCode() : " + darr.hashCode());

        /* 배열명.length : 배열의 길이(칸 수)를 반환*/
        System.out.println("iarr.length : " + iarr.length);
        System.out.println("darr.length : " + darr.length);

        /* 한 번 생성된 배열은 길이를 변경할 수 없다.
         * -> 새로운 배열을 생성하여
         *       기존 참조형 변수에 새 배열의 주소를 대입
         *           -> 새 배열 참조
         *
         * */

        iarr = new int[100];
        System.out.println("수정된 iarr.hashCode() : " + iarr.hashCode());
        System.out.println("수정된 iarr.length : " + iarr.length);

        /* DB의 NULL : 빈 칸(저장된 데이터가 없다)
         * JAVA의 NULL : 저장된 주소가 없다.(참조하는 객체가 없다.)
         * */

        iarr = null;    // iarr에 아무배열도 참조하지 않는다는 null 대입

        /*  java.lang.NullPointerException
         *   아무것도 참조하지 않는 변수(null)을 이용할 때 발생하는 예외
         * */
        System.out.println("수정된 iarr.hashCode() : " + iarr.hashCode());
        System.out.println("수정된 iarr.length : " + iarr.length);

    }

}
