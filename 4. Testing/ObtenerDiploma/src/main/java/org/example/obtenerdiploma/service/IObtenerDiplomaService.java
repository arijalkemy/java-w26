package org.example.obtenerdiploma.service;


import org.example.obtenerdiploma.model.StudentDTO;

public interface IObtenerDiplomaService {

    StudentDTO analyzeScores(StudentDTO rq);
}
