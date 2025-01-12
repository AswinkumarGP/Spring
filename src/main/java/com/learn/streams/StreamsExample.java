package com.learn.streams;

import com.learn.functionalInterface.Person;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamsExample {

    public static void mapExample(){
        Set<Integer> ageSet = Person.getPersonList().stream()
                //.map(Person -> Person.getAge())
                .map(Person::getAge)
                .collect(Collectors.toSet());
        System.out.println(ageSet);
    }

    public static void flatMapExample(){
        List<String> hobbiesSet = Person.getPersonList().stream()
                //.map(Person -> Person.getHobbies())
                .map(Person::getHobbies)
                //.flatMap(List -> List.stream())
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(hobbiesSet);
    }

    public static void distinctCountSortedExample(){
        List<String> distinctHobbies = Person.getPersonList().stream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());

        long distinctHobbiesCount = Person.getPersonList().stream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .distinct()
                .count();

        List<String> distinctHobbiesSort = Person.getPersonList().stream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        List<Person> sortedPersonName = Person.getPersonList().stream()
                .sorted(Comparator.comparing(Person::getName).reversed())
                .collect(Collectors.toList());

        System.out.println(distinctHobbies);
        System.out.println(distinctHobbiesCount);
        System.out.println(distinctHobbiesSort);
        sortedPersonName.forEach(Person -> System.out.println(Person.getName()));
    }

    public static void reduceExample(){
        int ageSum1 = Person.getPersonList().stream()
                .filter(Person -> Person.getAge() > 29)
                .map(Person -> Person.getAge())
                .reduce(0, (a,b) -> a+b);

        System.out.println(ageSum1);

        Optional<Integer> ageSum = Person.getPersonList().stream()
                .filter(Person -> Person.getAge() > 29)
                .map(Person -> Person.getAge())
                .reduce((a,b) -> a+b);

        if (ageSum.isPresent()){
            System.out.println(ageSum.get());
        }
    }

    public static void skipLimitExample(){
        List<String> hobbiesList = Person.getPersonList().stream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .limit(2)
                .collect(Collectors.toList());

        System.out.println(hobbiesList);

        List<String> hobbiesList1 = Person.getPersonList().stream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .skip(2)
                .collect(Collectors.toList());

        System.out.println(hobbiesList1);
    }

    public static void anyAllNoneMatchExample(){
        boolean val = Person.getPersonList().stream()
                .map(Person -> Person.getAge())
                .anyMatch(a -> a<27);

        System.out.println(val);

        boolean val1 = Person.getPersonList().stream()
                .map(Person -> Person.getAge())
                .allMatch(a -> a<27);

        System.out.println(val1);

        boolean val2 = Person.getPersonList().stream()
                .map(Person -> Person.getAge())
                .noneMatch(a -> a<27);

        System.out.println(val2);
    }

    public static void findAnyFirstExample(){
        Optional<Person> optionalPerson = Person.getPersonList().stream()
                .filter(Person -> Person.getAge() == 30)
                .findAny();
        //.findFirst();

        if (optionalPerson.isPresent()){
            System.out.println(optionalPerson.get().getName());
        }
    }

    public static void factoryMethods(){
        Stream.of(1, 2, 3).forEach(System.out::print);
        Stream.iterate(1, a -> a+1).limit(5).forEach(System.out::print);
        Stream.generate(() -> new Random()).limit(5).forEach(Random -> System.out.println(Random.nextInt()));
    }

    public static void numericStreams(){
        IntStream.range(1,5).forEach(System.out::print);
        System.out.println(IntStream.range(1,5).count());
        IntStream.rangeClosed(1,5).forEach(System.out::print);
        System.out.println(IntStream.rangeClosed(1,5).count());

        LongStream.range(1,5).forEach(System.out::print);
        System.out.println(LongStream.range(1,5).count());
        LongStream.rangeClosed(1,5).forEach(System.out::print);
        System.out.println(LongStream.rangeClosed(1,5).count());

        IntStream.range(1,5).asDoubleStream().forEach(System.out::print);
        LongStream.rangeClosed(1,5).asDoubleStream().forEach(System.out::print);

        System.out.println();
        System.out.println(IntStream.rangeClosed(1,5).sum());
        OptionalInt optionalInt = IntStream.rangeClosed(1,5).max();
        //.min;
        System.out.println(optionalInt.isPresent() ? optionalInt.getAsInt() : 0);
        OptionalDouble optionalDouble = IntStream.rangeClosed(1,5).average();
        System.out.println(optionalDouble.isPresent()? optionalDouble.getAsDouble(): 0);

        System.out.println(IntStream.rangeClosed(1,5).boxed().collect(Collectors.toList()));
        System.out.println(IntStream.rangeClosed(1,5).mapToObj(i->i+1).collect(Collectors.toList()));
        System.out.println(LongStream.rangeClosed(1,5).mapToDouble(i->i).boxed().collect(Collectors.toList()));
    }

    public static void joiningCountingMappingMinByMaxBySummingIntAvgInt(){
        System.out.println(Person.getPersonList().stream()
                .map(Person::getName)
                .collect(Collectors.joining()));

        System.out.println(Person.getPersonList().stream()
                .map(Person::getName)
                .collect(Collectors.joining("-")));

        System.out.println(Person.getPersonList().stream()
                .map(Person::getName)
                .collect(Collectors.joining("-", "(" , ")")));

        System.out.println(Person.getPersonList().stream()
                .collect(counting()));

        System.out.println(Person.getPersonList().stream()
                .collect(mapping(Person::getName, toList())));

        System.out.println(Person.getPersonList().stream()
                .collect(minBy(Comparator.comparing(Person -> {return Person.getAge();}))).get().getName());

        System.out.println(Person.getPersonList().stream()
                .collect(maxBy(Comparator.comparing(Person::getAge))).get().getName());

        System.out.println(Person.getPersonList().stream()
                .collect(summingInt(Person::getAge)));

        System.out.println(Person.getPersonList().stream()
                .collect(averagingDouble(Person::getAge)));
    }

    public static void groupingPartitioningBy(){
        LinkedHashMap<Integer, Set<Person>> map = Person.getPersonList().stream()
                .collect(groupingBy(Person::getAge, LinkedHashMap::new, Collectors.toSet()));
        System.out.println(map);

        Map<Boolean, List<Person>> map1 = Person.getPersonList().stream()
                .collect(partitioningBy(Person -> Person.getAge() <= 30, toList()));
        System.out.println(map1);
    }

    public static void main(String[] args) {
        mapExample();
        flatMapExample();
        distinctCountSortedExample();
        reduceExample();
        skipLimitExample();
        anyAllNoneMatchExample();
        findAnyFirstExample();
        factoryMethods();
        numericStreams();
        joiningCountingMappingMinByMaxBySummingIntAvgInt();
        groupingPartitioningBy();
    }
}
