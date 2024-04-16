package com.example.demo.Athletes.Domain;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    private String name;
    private String lastName;
    private int age;

    List<Sport> sports;
}
