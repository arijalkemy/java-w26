package com.example.CRUD_JPA.controller;

import com.example.CRUD_JPA.model.Student;
import com.example.CRUD_JPA.service.IStudentService;
import com.example.CRUD_JPA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private IStudentService iStudentService;
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public  String createStudent(@RequestBody Student student){
        iStudentService.saveStudent(student);
        return "El estudiante fue agregado correctamente";
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> studentList = iStudentService.getStudents();
        return studentList;
    }
    @PostMapping("edit/{id}")
    public Student editStudent(@PathVariable long id, @RequestParam("name") String newName, @RequestParam ("lastname") String newLastName){
        Student stu = studentService.findStudent(id);
        stu.setLastname(newName);
        stu.setName(newName);
        stu.setLastname(newLastName);
        studentService.saveStudent(stu);
        return stu;
    }
    @PostMapping("delete/{id}")
    public String deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return "El estudiante fue borrado correctamente";
    }
}
