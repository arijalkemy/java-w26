package org.meli.obtenerdiploma.service;

import org.meli.obtenerdiploma.model.StudentDTO;

public interface IObtenerDiplomaService {

    StudentDTO analyzeScores(StudentDTO rq);
}
