package org.meli.ejercicio6_p3_d1_estudiante.controller;

import org.meli.ejercicio6_p3_d1_estudiante.dto.StudentRequestDTO;
import org.meli.ejercicio6_p3_d1_estudiante.dto.StudentResponseDTO;
import org.meli.ejercicio6_p3_d1_estudiante.dto.StudentToUpdateRequestDTO;
import org.meli.ejercicio6_p3_d1_estudiante.service.Iservice.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponseDTO> save(@RequestBody StudentRequestDTO studentRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestParam String identification,
                                       @RequestParam String name,
                                       @RequestParam String lastName) {
        studentService.udpate(id, identification, name, lastName);
        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public ResponseEntity<Void> update(@RequestBody StudentToUpdateRequestDTO studentToUpdateRequestDTO) {
        studentService.udpate(studentToUpdateRequestDTO);
        return ResponseEntity.noContent().build();
    }

}
