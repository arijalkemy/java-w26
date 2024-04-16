package com.meli.EdadPersona.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PersonServiceImpl implements IPersonService {
    public int getAge(int day, int month, int year){
        LocalDate actualDate = LocalDate.now();
        LocalDate personDate = LocalDate.of(year, month, day);

        return actualDate.compareTo(personDate);
    }
}
