# 람다, 메서드 참조, 생성자 참조 실습 과제

## 1. 기본 람다 실습
1. List<Integer>를 생성하고 짝수만 필터링하는 람다 작성
2. 같은 리스트에서 모든 값을 2배로 변환하는 map 람다 작성
3. 리스트의 모든 값을 더하는 reduce 람다 작성

## 2. 메서드 참조 실습
1. 문자열 리스트를 String::toUpperCase로 전체 대문자로 변환
2. 정수 리스트를 System.out::println으로 출력
3. 객체 리스트에서 Objects::isNull로 null 요소만 필터링

## 3. 생성자 참조 실습
Person(String name, int age) 클래스 정의 후:

1. (name, age) -> new Person(name, age) → Person::new
2. 이름 리스트를 기반으로 (name) -> new Person(name, 0)을 생성자 참조로 변환해 List<Person> 생성
3. Supplier<Person>로 기본 생성자 참조 사용

## 4. 종합 프로젝트
1. Person 리스트 정렬: Comparator.comparing(Person::getAge)
2. 특정 문자로 시작하는 이름 필터링 (람다)
3. 필터된 사람들의 이름을 대문자로 변환 (메서드 참조)
4. 이름 목록으로 새로운 Person 리스트 생성 (생성자 참조)
