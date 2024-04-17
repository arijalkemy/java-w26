package com.javabootcamp.apiedad.service;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

@Service
public class AgeService {

        public int calculateAge(int day, int month, int year) throws ParseException {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            int yearNow = Year.now().getValue();
            LocalDate secondDate = LocalDate.of(year, month, day);
            int yearThen = secondDate.getYear();
            int diffYear = yearNow - yearThen;
            return diffYear;

        }
}
