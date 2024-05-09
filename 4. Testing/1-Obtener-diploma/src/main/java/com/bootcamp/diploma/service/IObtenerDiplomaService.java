package com.bootcamp.diploma.service;


import com.bootcamp.diploma.model.StudentDTO;

public interface IObtenerDiplomaService {

    StudentDTO analyzeScores(StudentDTO rq);
}
