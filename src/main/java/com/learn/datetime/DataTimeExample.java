package com.learn.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.Date;

public class DataTimeExample {

    public static void localDate(){
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.of(2020, 11,14));
        System.out.println(LocalDate.ofYearDay(2023, 365));

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getYear());
        System.out.println(localDate.get(ChronoField.DAY_OF_MONTH));

        System.out.println(localDate.withYear(2020));
        System.out.println(localDate.with(ChronoField.DAY_OF_MONTH, 20));
        System.out.println(localDate.with(TemporalAdjusters.lastDayOfMonth()));

        System.out.println(localDate.plusDays(10));
        System.out.println(localDate.minusYears(2));
        System.out.println(localDate.plus(10, ChronoUnit.MONTHS));
        System.out.println(localDate.minus(Period.ofDays(10)));
        System.out.println(localDate.isLeapYear());
        System.out.println(localDate.isEqual(localDate.plusDays(10)));
        System.out.println(localDate.isBefore(localDate.plusDays(10)));
        System.out.println(localDate.isAfter(localDate.plusDays(10)));
    }

    public static void localDateTime(){
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println(localDateTime);
        System.out.println(localDateTime.toLocalTime());
        System.out.println(localDateTime.toLocalDate());
    }

    public static void zonedDateTime(){
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
        System.out.println(zonedDateTime1);

        System.out.println(zonedDateTime.getOffset());
        System.out.println(zonedDateTime1.getZone());

        System.out.println(ZonedDateTime.ofInstant(localDateTime, ZoneOffset.of("+2"), ZoneId.of("Europe/Brussels")));
    }

    public static void periodDurationInstant(){
        Period period = LocalDate.now().until(LocalDate.now().plusDays(1));
        System.out.println(period.getDays());

        Period period1 = Period.between(LocalDate.now(), LocalDate.now().plusMonths(2));
        System.out.println(period1.get(ChronoUnit.MONTHS));

        Duration duration1 = Duration.between(LocalTime.now().plusHours(2), LocalTime.now());
        System.out.println(duration1.getSeconds());

        System.out.println(Instant.now());
        System.out.println(Instant.ofEpochSecond(1000));
    }

    public static void covertDate(){
        Date date = new Date();
        System.out.println(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

        Date date2 = new Date().from(LocalDate.now().atTime(LocalTime.now()).atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(date2);

        java.sql.Date date1 = java.sql.Date.valueOf(LocalDate.now());
        System.out.println(date1);
        System.out.println(date1.toLocalDate());
    }

    public static void dateTimeFormatter(){
        System.out.println(LocalDate.parse("2023-07-14"));
        System.out.println(LocalTime.parse("12:00", DateTimeFormatter.ISO_LOCAL_TIME));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy*MM*dd'T'HH:mm:ss");
        System.out.println(LocalDateTime.parse("2023*07*14T11:00:10", formatter));
        System.out.println(LocalDateTime.now().format(formatter));
    }

    public static void main(String[] args) {
        localDate();
        localDateTime();
        zonedDateTime();
        periodDurationInstant();
        covertDate();
        dateTimeFormatter();
    }
}
