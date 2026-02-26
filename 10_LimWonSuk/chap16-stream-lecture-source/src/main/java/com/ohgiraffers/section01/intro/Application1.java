package com.ohgiraffers.section01.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Application1 {
    public static void main(String[] args) {

        List<String> list
                = new ArrayList<>(Arrays.asList("Hello", "stream", "world"));

        System.out.println("list = " + list);

       /* List 내에서 " stream "만 출력하기 */
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){ // 다음 요소가 있으면 true, 없으면 false
            String element = iterator.next(); // 다음 요소를 꺼네 element 대입

            if ("stream".equals(element)){
                System.out.println(" 걸러낸 값 : " + element);
            }
        }

        /* 위 동작을 Stream을 이용해서 수행 */
        list
                .stream()
                //.filter("stres")
                .filter("stres"::equals)
              //  .filter(element -> "stream".equals(element)) // 람다식
                .forEach(str->System.out.println("필터링된 값 : " + str));



        /* stream의 병렬 처리 */


    }
}
