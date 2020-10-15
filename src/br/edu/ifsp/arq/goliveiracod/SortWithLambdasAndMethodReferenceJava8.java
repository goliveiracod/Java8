package br.edu.ifsp.arq.goliveiracod;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class SortWithLambdasAndMethodReferenceJava8 {
    public static void main(String[] args) {
        List<String> professions = new ArrayList<>(10);
        professions.add("Accountant");
        professions.add("Actor");
        professions.add("Administrator");
        professions.add("Architect");
        professions.add("Athlete");
        professions.add("Babysitter");
        professions.add("Baker");
        professions.add("Bricklayer");

        System.out.println("sorting the list without the lambda");
        professions.sort(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        });

        System.out.println("sorting the list with lambda by the word length");
        professions.sort((s, t1) -> {
            return s.length() - t1.length();
        });

        /* ########################################################################################################## */
        System.out.println("sorting using the comparator without lambda and method reference");
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        Comparator<String> comparator = Comparator.comparing(function);
        professions.sort(comparator);
        professions.forEach(System.out::println);

        System.out.println("sorting using the comparator with lambda");
        professions.sort(Comparator.comparing(s -> s.length()));
        professions.forEach(System.out::println);

        System.out.println("sorting using the comparator with method reference");
        professions.sort(Comparator.comparing(String::length));
        professions.forEach(System.out::println);
    }
}
