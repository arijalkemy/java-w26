package org.example.crud_jpa.controller;

import org.example.crud_jpa.dto.StudentRequestDTO;
import org.example.crud_jpa.dto.StudentResponseDTO;
import org.example.crud_jpa.exceptions.NotFoundException;
import org.example.crud_jpa.service.IStudentService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @PostMapping("/new")
    ResponseEntity<StudentResponseDTO> createStudent(@RequestBody StudentRequestDTO newStudent){
        return ResponseEntity.ok(studentService.saveStudent(newStudent));
    }

    @GetMapping("/students")
    ResponseEntity<List<StudentResponseDTO>> getStudents(){
        return ResponseEntity.ok(studentService.getStudents());
    }

    @PutMapping("edit/{id}")
    ResponseEntity<StudentResponseDTO> putStudent(@PathVariable Long id,
                                                  @RequestParam (value = "name",
                                                          required = false)
                                                  String newName,
                                                  @RequestParam (value = "lastname",
                                                          required = false)
                                                  String newLastName) throws NotFoundException {
        return ResponseEntity.ok(studentService.updateStudent(id,newName,newLastName));
    }

    @DeleteMapping("delete/{id}")
    ResponseEntity<?> deleteStudentById( @PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Estudiante eliminado");
    }

}
