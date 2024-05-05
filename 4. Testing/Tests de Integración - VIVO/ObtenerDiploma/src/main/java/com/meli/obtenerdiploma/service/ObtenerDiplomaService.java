package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
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
        String baseMessage  = "El alumno " + studentName + " ha obtenido un promedio de ";
        String averageString   = ((average == null) ? "null" : new DecimalFormat("#0.00").format(average));
        String greatingMessage = ((average == null) ? "" : ((average >= 9) ? ". Felicitaciones!" : ". Puedes mejorar.")); 
        
    return baseMessage + averageString + greatingMessage;
    }

    private Double calculateAverage(List<SubjectDTO> scores) {
        if (scores == null) {
            return null;
        }

        return scores.stream()
                .reduce(0D, (partialSum, score)  -> partialSum + score.getScore(), Double::sum)
                / scores.size();
    }
}
