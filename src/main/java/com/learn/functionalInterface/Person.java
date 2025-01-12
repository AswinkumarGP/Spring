package com.learn.functionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {

    String name;
    int age;
    List<String> hobbies;

    public Person(String name, int age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public static List<Person> getPersonList(){
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person("Aswin", 30, Arrays.asList("Cricket", "Football", "TV"));
        Person person2 = new Person("Losh", 26, Arrays.asList("TV", "Songs"));
        personList.add(person1);
        personList.add(person2);
        return personList;
    }
}
