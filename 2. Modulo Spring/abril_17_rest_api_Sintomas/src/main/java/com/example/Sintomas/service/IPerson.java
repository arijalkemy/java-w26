package com.example.Sintomas.service;

import com.example.Sintomas.dto.PersonAndSymptom;

import java.util.List;

public interface IPerson {
    public List<PersonAndSymptom> getPersonsBySymptom();
}
