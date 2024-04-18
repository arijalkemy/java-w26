package com.spring.covid19.services;

import com.spring.covid19.dtos.SymptomDTO;

import java.util.List;

public interface ISymptomService {
    List<SymptomDTO> getAll();
    SymptomDTO getByName(String name);
}
