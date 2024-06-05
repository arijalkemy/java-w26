package org.meli.ejercicio6_p3_d1_estudiante.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CourseStudentId {
    private Long id_student;
    private Long id_course;
}
