package com.bootcamp.course.controller;

import com.bootcamp.course.dto.StudentDTO;
import com.bootcamp.course.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private IStudentService studentService;

    @Autowired
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
                                             @RequestParam(required = false) String identification,
                                             @RequestParam(required = false) String name,
                                             @RequestParam(required = false) String lastName,
                                             @RequestBody StudentDTO studentDTO) {

        if (identification != null && name != null && lastName != null)
            return ResponseEntity.ok().body(studentService.updatePartial(id, identification, name, lastName));

        return ResponseEntity.ok().body(studentService.update(id, studentDTO));

    }

    @GetMapping("/average/{student_id}")
    public ResponseEntity<StudentDTO> getStudentWithAverage(@PathVariable(name = "student_id") Long studentId) {
        return ResponseEntity.ok().body(studentService.findAverageStudent(studentId));
    }

}
