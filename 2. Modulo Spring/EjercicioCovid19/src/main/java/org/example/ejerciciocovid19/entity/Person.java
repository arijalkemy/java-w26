package org.example.ejerciciocovid19.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Person {
    private int id;
    private String name;
    private String lastName;
    private int age;
}
