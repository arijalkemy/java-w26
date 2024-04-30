package Ejercicio.ObtenerDiploma.service;

import Ejercicio.ObtenerDiploma.dto.StudentDTO;

public interface ICertificateService {
    StudentDTO analyzeScores(StudentDTO rq);
}
