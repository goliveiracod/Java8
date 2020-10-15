package br.edu.ifsp.arq.goliveiracod;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateJava8 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println();

        LocalDate worldCup = LocalDate.of(2022, Month.NOVEMBER, 21);
        int year = worldCup.getYear();
        System.out.println(year);
        System.out.println();

        Period period = Period.between(today, worldCup);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
        System.out.println();

        /* increment and decrement date */
        System.out.println(today.minusYears(1));
        System.out.println(today.minusMonths(4));
        System.out.println(today.minusDays(2));
        System.out.println(today.plusYears(1));
        System.out.println(today.plusMonths(4));
        System.out.println(today.plusDays(2));
        System.out.println();

        DateTimeFormatter formatBrazilDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(worldCup.format(formatBrazilDate));

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatWithTimeBrazilDate = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        System.out.println(now.format(formatWithTimeBrazilDate));
        System.out.println();

        YearMonth yearMonth = YearMonth.of(2033, Month.JANUARY);
        System.out.println(yearMonth);
        System.out.println();

        LocalTime localTime = LocalTime.of(12, 10);
        System.out.println(localTime);
        System.out.println();

        LocalDate birthDay = LocalDate.of(2020, Month.JANUARY, 23);
    }
}
