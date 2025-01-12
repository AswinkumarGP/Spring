package com.learn.functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FunctionalInterfaceExamples {

    static List<String> names = new ArrayList<String>();
    static List<Person> personList = Person.getPersonList();

     static void print(String a){
        System.out.println(a);
    }

    public static void main(String[] args) {
        names.add("Aswin");
        names.add("Losh");

        Consumer<String> c1 = FunctionalInterfaceExamples::print;
        names.forEach(name -> c1.accept(name));

        Consumer<Person> c2 = (Person) -> System.out.println(Person.getAge());
        personList.forEach( person -> c2.accept(person));

    }
}
