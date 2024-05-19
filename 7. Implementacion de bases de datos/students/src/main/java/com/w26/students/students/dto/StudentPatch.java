package com.w26.students.students.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StudentPatch implements Serializable {
    
    private String dni;

    private String name;
    @JsonAlias("last_name")
    private String lastName;
}
