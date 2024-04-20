package com.w26.covid19.dto;

import com.w26.covid19.entity.Symptom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FindAllSymptResult {
    private List<Symptom> symptomList;
    private String message;
}
