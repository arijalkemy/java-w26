package meli.bootcamp.obtenerdiploma.service;


import meli.bootcamp.obtenerdiploma.model.StudentDTO;

public interface IObtenerDiplomaService {

    StudentDTO analyzeScores(StudentDTO rq);
}
