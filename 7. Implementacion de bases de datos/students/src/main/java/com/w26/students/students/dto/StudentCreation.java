package com.w26.students.students.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StudentCreation implements Serializable {

    private Long id;

    private String name;
    @JsonAlias("last_name")
    private String lastName;
    private String dni;
}
