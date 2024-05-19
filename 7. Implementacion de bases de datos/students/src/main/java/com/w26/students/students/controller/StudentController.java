package com.w26.students.students.controller;

import org.springframework.web.bind.annotation.RestController;

import com.w26.students.students.dto.StudentCreation;
import com.w26.students.students.dto.StudentPatch;
import com.w26.students.students.dto.SuccesfullyResponse;
import com.w26.students.students.models.Student;
import com.w26.students.students.service.IStudentService;


import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/{id}") 
    public ResponseEntity<SuccesfullyResponse> getStudent(@PathVariable Long id) {
        Student response = studentService.get(id);
        System.out.println(response);
        return ResponseEntity.status(HttpStatus.OK).body(
            SuccesfullyResponse.builder()
                                .message("Estudiante encontrado.")
                                .result(response)
                                .build());
    }

    @GetMapping("all/{page}")
    public ResponseEntity<List<Student>> getAllStudents(@PathVariable Integer page) {
        List<Student> response = studentService.getAll(page);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("")
    public ResponseEntity<SuccesfullyResponse> postStudent(@RequestBody StudentCreation studentToCreate) 
    {
        studentService.create(studentToCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(
            SuccesfullyResponse.builder()
                               .message("Usuario creado")
                               .result("OK")
                               .build()
            );
    }

     
    @DeleteMapping("{id}")
    public ResponseEntity<SuccesfullyResponse> deleteStudent(@PathVariable Long id) 
    {
        studentService.delete(id);

        return ResponseEntity.status(HttpStatus.CREATED).body(
            SuccesfullyResponse.builder()
                               .message("El usuario con el id " + id + " fue eliminado")
                               .result("Usuario eliminado.")
                               .build()
            );
    }

    @PatchMapping("{id}")
    public ResponseEntity<SuccesfullyResponse> patchStudent(@PathVariable Long id, @RequestBody StudentPatch studentToPatch)
    {
        studentService.update(id, studentToPatch);
        return ResponseEntity.status(HttpStatus.OK).body(
            SuccesfullyResponse.builder()
                               .message("El usuario con el id " + id + " fue actualizado")
                               .result("Usuario actualizado.")
                               .build()
            );
    }
}
