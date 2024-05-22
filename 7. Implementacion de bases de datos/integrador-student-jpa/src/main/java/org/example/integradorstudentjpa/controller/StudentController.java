package org.example.integradorstudentjpa.controller;


import lombok.RequiredArgsConstructor;
import org.example.integradorstudentjpa.dto.StudentRequestDTO;
import org.example.integradorstudentjpa.dto.StudentUpdateDTO;
import org.example.integradorstudentjpa.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> saveStudent(@RequestBody StudentRequestDTO studentRequestDTO){
        studentService.saveStudent(studentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student saved!");
    }

    @PutMapping("/")
    @ResponseBody
    public ResponseEntity<?> updateStudent(@RequestBody StudentUpdateDTO studentUpdateDTO){
        studentService.updateStudent(studentUpdateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student saved!");
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getStudentById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findStudentById(id));
    }

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<?> getAllStudents(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @PostMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteStudentById(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student deleted!");

    }
}
