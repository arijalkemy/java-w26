package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @PostMapping(value = "/registerStudent", consumes = "application/json")
    public ResponseEntity<?> registerStudent(@RequestBody @Valid StudentDTO stu) {
        this.studentService.create(stu);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getStudent/{id}")
    public StudentDTO getStudent(@PathVariable Long id) {
        return this.studentService.read(id);
    }

    @PostMapping("/modifyStudent")
    public ResponseEntity<?> modifyStudent(@RequestBody @Valid StudentDTO stu) {
        this.studentService.update(stu);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/removeStudent/{id}")
    public ResponseEntity<?> removeStudent(@PathVariable Long id) {
        this.studentService.delete(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/listStudents")
    public Set<StudentDTO> listStudents() {
        return this.studentService.getAll();
    }

}
