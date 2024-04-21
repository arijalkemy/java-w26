package com.example.Sintomas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor

public class Symptom {
    private long id;
    private String name;
    private String severityLevel;



}
