package com.w26.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FindPersonRiskResult {
    private String message;
    private List<PersonRisk> personRiskList;
}
