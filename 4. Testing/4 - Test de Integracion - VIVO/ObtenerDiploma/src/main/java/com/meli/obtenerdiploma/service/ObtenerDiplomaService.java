package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ObtenerDiplomaService implements IObtenerDiplomaService {

    @Autowired
    IStudentDAO studentDAO;

    @Override
    public StudentDTO analyzeScores(Long studentId) {
        /* validation of studentId */
        if(studentId <= 0){
            throw new ObtenerDiplomaException("El id de estudiante no puede ser 0 o menor", HttpStatus.BAD_REQUEST);
        }

        StudentDTO stu = studentDAO.findById(studentId);

        stu.setAverageScore(calculateAverage(stu.getSubjects()));
        stu.setMessage(getGreetingMessage(stu.getStudentName(), stu.getAverageScore()));

        return stu;
    }

    private String getGreetingMessage(String studentName, Double average) {
        return "El alumno " + studentName + " ha obtenido un promedio de " + ((average == null) ? "null" : new DecimalFormat("#0.00").format(average))
                + ((average == null) ? "" : ((average >= 9) ? ". Felicitaciones!" : ". Puedes mejorar."));
    }

    private Double calculateAverage(List<SubjectDTO> scores) {
        return scores.stream()
                .reduce(0D, (partialSum, score)  -> partialSum + score.getScore(), Double::sum)
                / scores.size();
    }
}
