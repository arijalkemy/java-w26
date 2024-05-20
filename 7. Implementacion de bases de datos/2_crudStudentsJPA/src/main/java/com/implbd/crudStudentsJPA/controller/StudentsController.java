package com.implbd.crudStudentsJPA.controller;

import com.implbd.crudStudentsJPA.dto.StudentRequestDTO;
import com.implbd.crudStudentsJPA.dto.StudentResponseDTO;
import com.implbd.crudStudentsJPA.service.IStudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class StudentsController {

    @Autowired
    private IStudentService studentService;

    // CREATE
    @PostMapping("/create")
    ResponseEntity<String> createStudent(@Valid @RequestBody StudentRequestDTO student) {
        this.studentService.saveStudent(student);
        return new ResponseEntity<>("Es estudiante fue agregado correctamente", HttpStatus.CREATED);
    }

    // -----------

    // GET ALL
    @GetMapping("/students")
    ResponseEntity<List<StudentResponseDTO>> getStudents() {
        List<StudentResponseDTO> students = this.studentService.getStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // GET BY ID
    @GetMapping("/students/{id}")
    ResponseEntity<StudentResponseDTO> getStudentsById(
            @Positive(message = "El id debe ser un numero mayor a cero")
            @PathVariable Long id
    ) {
        StudentResponseDTO student = this.studentService.findStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // -----------

    // UPDATE
    @PutMapping("/edit/{id}")
    ResponseEntity<StudentResponseDTO> editStudent(
            @Positive(message = "El id debe ser un numero mayor a cero")
            @PathVariable Long id,
            @RequestParam String newName,
            @RequestParam String newLastname
    ) {
        StudentResponseDTO student = this.studentService.updateStudent(id, newName, newLastname);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // -----------

    // DELETE
    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteStudent(
            @Positive(message = "El id debe ser un numero mayor a cero")
            @PathVariable Long id
    ) {
        this.studentService.deleteStudent(id);
        return new ResponseEntity<>("Estudiante borrado correctamente", HttpStatus.OK);
    }

}
