package com.testing.obtenerdiploma_unit_mocks.service;


import com.testing.obtenerdiploma_unit_mocks.model.StudentDTO;

public interface IObtenerDiplomaService {

    StudentDTO analyzeScores(Long studentId);
}
