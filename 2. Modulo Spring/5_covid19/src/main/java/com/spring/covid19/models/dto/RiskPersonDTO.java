package com.spring.covid19.models.dto;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class RiskPersonDTO implements Serializable {

    private String fullName;
    private List<String> symptoms;

    public RiskPersonDTO(String fullName, List<String> symptoms) {
        this.fullName = fullName;
        this.symptoms = symptoms;
    }
}
