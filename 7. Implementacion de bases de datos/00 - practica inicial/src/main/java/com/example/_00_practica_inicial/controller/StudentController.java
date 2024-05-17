package com.example._00_practica_inicial.controller;

import com.example._00_practica_inicial.dto.StudentRequestDTO;
import com.example._00_practica_inicial.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    IStudentService iStudentService;

    @PostMapping
    ResponseEntity<?> addStudent(@RequestBody StudentRequestDTO studentRequest){
        return new ResponseEntity<>(iStudentService.add(studentRequest), HttpStatus.CREATED);
    }
}
