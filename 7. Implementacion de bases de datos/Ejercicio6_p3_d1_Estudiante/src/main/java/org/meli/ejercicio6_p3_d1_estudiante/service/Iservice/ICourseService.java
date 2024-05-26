package org.meli.ejercicio6_p3_d1_estudiante.service.Iservice;

import org.meli.ejercicio6_p3_d1_estudiante.dto.CourseRequestDTO;
import org.meli.ejercicio6_p3_d1_estudiante.dto.StudentRequestDTO;
import org.meli.ejercicio6_p3_d1_estudiante.dto.StudentResponseDTO;

public interface ICourseService {
    CourseRequestDTO listAllCourses(CourseRequestDTO courseRequestDTO);
}
