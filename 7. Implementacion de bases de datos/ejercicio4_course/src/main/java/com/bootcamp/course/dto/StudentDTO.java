package com.bootcamp.course.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StudentDTO implements Serializable {

    private Long id;
    private String identification;
    private String name;
    @JsonProperty("last_name")
    private String lastName;
    private Double note1;
    private Double note2;
    private Double average;

}
