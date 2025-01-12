package com.learn.optional;

import com.learn.functionalInterface.Person;

import java.util.List;
import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {

        Optional<String> stringOptional = Optional.ofNullable("Aswin");
        System.out.println(stringOptional.isPresent());
        stringOptional.ifPresent(System.out::println);

        System.out.println(stringOptional.filter(String -> String.length() == 4).orElse("Default"));

        System.out.println(stringOptional.filter(String -> String.length() == 4).orElseGet(() -> {
            return "Default";
        }));

        //System.out.println(stringOptional.filter(String -> String.length() == 4).orElseThrow(() -> {
        //    return new RuntimeException();
        //}));

        Optional<Person> listOptional = Optional.ofNullable(Person.getPersonList().get(0));
        listOptional.map(Person::getHobbies).ifPresent(s -> System.out.println(s));

    }
}
