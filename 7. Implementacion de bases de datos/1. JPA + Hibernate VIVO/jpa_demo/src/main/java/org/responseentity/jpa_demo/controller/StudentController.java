package org.responseentity.jpa_demo.controller;

import org.responseentity.jpa_demo.model.Student;
import org.responseentity.jpa_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public Student postStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return student;
    }
}
