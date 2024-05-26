package org.meli.ejercicio6_p3_d1_estudiante.controller;

import lombok.RequiredArgsConstructor;
import org.meli.ejercicio6_p3_d1_estudiante.dto.CourseRequestDTO;
import org.meli.ejercicio6_p3_d1_estudiante.dto.StudentRequestDTO;
import org.meli.ejercicio6_p3_d1_estudiante.dto.StudentResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    @GetMapping("/allcourses")
    public ResponseEntity<CourseRequestDTO> getAllCourses() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
