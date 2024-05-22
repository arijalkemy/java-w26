package com.bootcamp.crud.controller;

import com.bootcamp.crud.model.Student;
import com.bootcamp.crud.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    // Create
    @PostMapping()
    public String createStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "Estudiante creado exitosamente";
    }

    // Read
    @GetMapping()
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    // Update
    @PostMapping("/{id}")
    public Student editStudent(@PathVariable Long id, @RequestParam String name) {
        Student student = studentService.findStudent(id);
        student.setName(name);
        studentService.saveStudent(student);
        return student;
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Estudiante eliminado exitosamente";
    }
}
