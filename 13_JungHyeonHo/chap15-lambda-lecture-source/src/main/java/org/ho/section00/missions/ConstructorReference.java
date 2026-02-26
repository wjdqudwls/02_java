package org.ho.section00.missions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class ConstructorReference {
  public static void main(String[] args) {
    BiFunction<String,Integer,Person> makePerson
//        = new BiFunction<String, Integer, Person>() {
//      @Override
//      public Person apply(String s, Integer integer) {
//        return new Person(s,integer);
//      }
//    };
//        = (str,num)->new Person(str,num);
    = Person::new;



    List<String> people = new ArrayList<>();
    for(int i=0;i<100;i++){
      people.add(Generator.makeRandomString());
    }
    System.out.println(people);

    Person[] pArray = people.stream().map(name -> new Person(name, 0)).toArray(Person[]::new);
    System.out.println("Arrays.toString(pArray) = " + Arrays.toString(pArray));
  }
}
