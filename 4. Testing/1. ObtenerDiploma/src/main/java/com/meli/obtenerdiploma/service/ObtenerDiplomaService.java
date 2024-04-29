package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import java.text.DecimalFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    return String.format("El alumno %s ha obtenido un promedio de %s%s",
        studentName,
        new DecimalFormat("#.##").format(average),
        (average > 9) ? ". Felicitaciones!" : ". Puedes mejorar."
    );
  }

  private Double calculateAverage(List<SubjectDTO> scores) {
    return scores.stream()
        .reduce(0D, (sum, score) -> sum + score.getScore(), Double::sum) / scores.size();
  }
}
