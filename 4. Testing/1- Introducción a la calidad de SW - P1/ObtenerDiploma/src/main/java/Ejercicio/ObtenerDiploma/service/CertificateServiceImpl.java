package Ejercicio.ObtenerDiploma.service;

import Ejercicio.ObtenerDiploma.dto.StudentDTO;
import Ejercicio.ObtenerDiploma.dto.SubjectDTO;
import org.springframework.stereotype.Service;
import java.text.DecimalFormat;
import java.util.List;

@Service
public class CertificateServiceImpl implements ICertificateService {
    @Override
    public StudentDTO analyzeScores(StudentDTO studentDtoRequest) {
        studentDtoRequest.setAverageScore(calculateAverage(studentDtoRequest.getSubjects()));
        studentDtoRequest.setMessage(getGreetingMessage(studentDtoRequest.getStudentName(), studentDtoRequest.getAverageScore()));
        return studentDtoRequest;
    }

    private String getGreetingMessage(String studentName, Double average) {
        return "El alumno " + studentName + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ((average > 9) ? ". Felicitaciones!" : ". Puedes mejorar.");
    }

    private Double calculateAverage(List<SubjectDTO> scores) {
        return scores.stream()
                .reduce(0D, (partialSum, score)  -> partialSum + score.getScore(), Double::sum)
                / scores.size();
    }
}
