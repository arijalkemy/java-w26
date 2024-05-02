package org.bootcamp.athletes.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private String lastName;
    private Integer age;
    private Sport sport;
}
