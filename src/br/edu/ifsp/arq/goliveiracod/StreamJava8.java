package br.edu.ifsp.arq.goliveiracod;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamJava8 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(10);
        people.add(new Person("Gabriel", 18));
        people.add(new Person("Camila", 32));
        people.add(new Person("Carlos", 34));
        people.add(new Person("Emily", 59));
        people.add(new Person("Nelson", 103));
        people.add(new Person("Paulo", 42));

        System.out.println("sorting by age");
        people.sort(Comparator.comparingInt(Person::getAge));
        people.forEach(System.out::println);
        System.out.println();

        /* ########################################################################################################## */
        System.out.println("using Stream with filter");
        Stream<Person> streamPerson = people.stream().filter(person -> person.getAge() > 18);
        streamPerson.forEach(System.out::println);
        System.out.println();

        System.out.println("without the temporary variable");
        people.stream().filter(person -> person.getAge() < 100).forEach(System.out::println);
        System.out.println();

        System.out.println("without the lambda");
        people.stream().filter(new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge() < 30;
            }
        }).forEach(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person);
            }
        });
        System.out.println();

        System.out.println("map");
        Stream<Integer> ages = people.stream()
                .filter(person -> person.getAge() < 100)
                .map(Person::getAge);
        ages.forEach(System.out::println);

        System.out.println("mapToInt (int) and method sum");
        int sumAges = people.stream().mapToInt(Person::getAge).sum();
        System.out.println(sumAges);
        System.out.println();

        System.out.println("findAny");
        Optional<Person> optional = people.stream()
                .findAny();
        optional.ifPresent(System.out::println);
        System.out.println();

        System.out.println("generate collections");
        List<Person> newPeople = people.stream()
                .filter(person -> person.getAge() < 100)
                .collect(Collectors.toList());

        Set<Person> newPeopleSet = people.stream()
                .filter(person -> person.getAge() < 100)
                .collect(Collectors.toSet());



        /*note that parallelStream is used here, instead of the stream.
         *ParallelStream works with multithreaded processing.
         * */
        Map peopleMap = people
                .parallelStream()
                .filter(person -> person.getAge() < 100)
                .collect(Collectors.toMap(Person::getName, Person::getAge));
        peopleMap.forEach((name, age) -> {
            System.out.println(name + " " + age);
        });
        System.out.println();
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return name + " " + age;
    }
}