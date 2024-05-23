package com.bootcamp.course.controller;

import com.bootcamp.course.dto.StudentDTO;
import com.bootcamp.course.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDTO> save(@RequestBody StudentDTO studentDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentDTO));
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(studentService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable Long id,
                                       @RequestParam String identification,
                                       @RequestParam String name,
                                       @RequestParam String lastName) {
        return ResponseEntity.ok().body(studentService.update(id, identification, name, lastName));
    }

    @PutMapping()
    public ResponseEntity<StudentDTO> update(@RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok().body(studentService.update(studentDTO));
    }

    @GetMapping("/average/{student_id}")
    public ResponseEntity<StudentDTO> getStudentWithAverage(@PathVariable(name = "student_id") Long studentId) {
        return ResponseEntity.ok().body(studentService.findAverageStudent(studentId));
    }

}
