package com.mercadolibre.covid19.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class RiskPerson {
    private String firstName;
    private String lastName;
    private List<String> symptoms;
}
