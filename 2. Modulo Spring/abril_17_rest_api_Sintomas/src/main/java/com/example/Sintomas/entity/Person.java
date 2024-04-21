package com.example.Sintomas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private long id;
    private String name, lastName;
    private int age;
}
