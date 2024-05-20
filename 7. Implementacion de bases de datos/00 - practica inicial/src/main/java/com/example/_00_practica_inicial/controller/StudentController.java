package com.example._00_practica_inicial.controller;

import com.example._00_practica_inicial.dto.request.StudentRequestDTO;
import com.example._00_practica_inicial.dto.response.ResponseDto;
import com.example._00_practica_inicial.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    IStudentService iStudentService;

    @PostMapping
    ResponseEntity<?> addStudent(@RequestBody StudentRequestDTO studentRequest){
        return new ResponseEntity<>(iStudentService.add(studentRequest), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<?> getStudents(){
        return new ResponseEntity<>(iStudentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getStudent(@PathVariable int id) throws Exception {
        return new ResponseEntity<>(iStudentService.getStudent(id), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    ResponseEntity<?> editStudent(@PathVariable int id,
                                  @RequestParam String name) throws Exception {
        return new ResponseEntity<>(iStudentService.edit(id, name), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteStudent(@PathVariable int id) throws Exception {
        iStudentService.deleteStudent(id);

        return new ResponseEntity<>(new ResponseDto("Eliminacion exitosa"), HttpStatus.OK);
    }

}
