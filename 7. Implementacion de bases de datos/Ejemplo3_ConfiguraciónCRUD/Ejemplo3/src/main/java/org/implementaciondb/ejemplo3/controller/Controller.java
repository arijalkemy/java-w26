package org.implementaciondb.ejemplo3.controller;

import org.implementaciondb.ejemplo3.model.Student;
import org.implementaciondb.ejemplo3.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private IStudentService stuServ;

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student) {
        stuServ.saveStudent(student);
        return "El estuddiante fue agregado correctamente";
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return stuServ.getStudents();
    }

    @PostMapping("edit/{id}")
    public Student editStudent(@PathVariable long id,
                               @RequestParam("name") String newName,
                               @RequestParam("lastName") String newLastname
    ) {
        Student stu = stuServ.findStudent(id);
        stu.setLastName(newName);
        stu.setLastName(newLastname);
        stuServ.saveStudent(stu);
        return stu;
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable long id) {
        stuServ.deleteStudent(id);
        return "El estudiante fue borradao correctamente";
    }

}
