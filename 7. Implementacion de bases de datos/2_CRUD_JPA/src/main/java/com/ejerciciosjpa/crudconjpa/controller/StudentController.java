package com.ejerciciosjpa.crudconjpa.controller;

import com.ejerciciosjpa.crudconjpa.model.Student;
import com.ejerciciosjpa.crudconjpa.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    IStudentService studentService;

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return "Estudiante guardado exitosamente";
    }
    @PostMapping("/edit/{id}")
    public Student editStudent(@PathVariable Long id,
                               @RequestParam("name") String newName,
                               @RequestParam("lastName") String newLastName){
        return studentService.updateStudent(id,newName,newLastName);

    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "Se borro el estudiante";
    }
}
