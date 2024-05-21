package com.mercadolibre.testcases.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateMapper {
    public static LocalDate toLocalDate(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, dateTimeFormatter);
    }
}
