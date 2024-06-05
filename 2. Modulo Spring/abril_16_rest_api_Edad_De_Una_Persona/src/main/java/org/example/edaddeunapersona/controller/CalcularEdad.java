package org.example.edaddeunapersona.controller;

import org.example.edaddeunapersona.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalcularEdad {

    @Autowired
    IUserService userService;

    @GetMapping("/birthdate")
    public ResponseEntity<Integer> index
            (@RequestParam String day, @RequestParam String month, @RequestParam String year) {
        return new ResponseEntity<>(
                userService.obtainUserAge(day, month, year),
                HttpStatus.OK
        );
    }
}
