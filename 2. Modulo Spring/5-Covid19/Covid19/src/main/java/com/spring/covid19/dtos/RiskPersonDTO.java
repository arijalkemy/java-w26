package com.spring.covid19.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiskPersonDTO {
    private String name;
    private String lastname;
}
