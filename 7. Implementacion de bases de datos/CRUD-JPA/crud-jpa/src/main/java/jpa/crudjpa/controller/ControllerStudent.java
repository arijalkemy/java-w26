package jpa.crudjpa.controller;

import jpa.crudjpa.model.Student;
import jpa.crudjpa.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerStudent {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "El estudiante fue agregado correctamente";
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> studentList = studentService.getStudents();
        return studentList;
    }

    @PostMapping("edit/")
    public Student editStudent(@PathVariable long id,
                               @RequestParam("name") String newName,
                               @RequestParam("lastName") String newLastName
    ) {
        Student student = studentService.findStudent(id);
        student.setName(newName);
        student.setLastName(newLastName);
        studentService.saveStudent(student);
        return student;
    }

    @PostMapping("delete/{id}")
    public String deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return "El estudiante fue borrado correctamente";
    }


}
