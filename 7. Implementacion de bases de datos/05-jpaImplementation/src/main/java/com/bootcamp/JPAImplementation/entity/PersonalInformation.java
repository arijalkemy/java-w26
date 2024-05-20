package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Embeddable
public class PersonalInformation {
    private String name;
    private String lastName;
    private String email;
}
