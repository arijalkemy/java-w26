package Ejercicio.ObtenerDiploma.entity;

import Ejercicio.ObtenerDiploma.dto.SubjectDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    String studentName;
    String message;
    Double averageScore;
    List<SubjectDTO> subjects;
}
