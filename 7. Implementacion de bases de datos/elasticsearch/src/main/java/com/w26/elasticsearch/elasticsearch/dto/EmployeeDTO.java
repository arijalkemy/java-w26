package com.w26.elasticsearch.elasticsearch.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO implements Serializable {

    @NotBlank
    private String name;
    @NotBlank
    private String lastName;

    @NotNull
    private Integer age;

    @NotBlank
    private String city;

    @NotBlank
    private String province;
}
