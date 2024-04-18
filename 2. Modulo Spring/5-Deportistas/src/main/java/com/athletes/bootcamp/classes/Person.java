package com.athletes.bootcamp.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Person {
    private String name;
    private String surname;
    private Integer age;
    private Sport sport;
}
