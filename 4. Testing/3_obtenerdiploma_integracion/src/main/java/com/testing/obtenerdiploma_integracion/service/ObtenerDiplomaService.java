package com.testing.obtenerdiploma_integracion.service;

import com.testing.obtenerdiploma_integracion.model.StudentDTO;
import com.testing.obtenerdiploma_integracion.model.SubjectDTO;
import com.testing.obtenerdiploma_integracion.repository.IStudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class ObtenerDiplomaService implements IObtenerDiplomaService {

    @Autowired
    IStudentDAO studentDAO;

    @Override
    public StudentDTO analyzeScores(Long studentId) {
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
