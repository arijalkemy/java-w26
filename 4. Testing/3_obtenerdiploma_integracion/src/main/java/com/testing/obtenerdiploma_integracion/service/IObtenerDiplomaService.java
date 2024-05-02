package com.testing.obtenerdiploma_integracion.service;

import com.testing.obtenerdiploma_integracion.model.StudentDTO;

public interface IObtenerDiplomaService {

    StudentDTO analyzeScores(Long studentId);
}
