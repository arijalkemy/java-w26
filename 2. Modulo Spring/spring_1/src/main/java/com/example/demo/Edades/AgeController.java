package com.example.demo.Edades;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ages")
public class AgeController {


    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<?> getAge(@PathVariable("day") int day, @PathVariable("month") int month, @PathVariable("year") int year) {

        LocalDate birthdate = LocalDate.of(year, month, day);
        LocalDate dateNow = LocalDate.now();
        int age = Period.between(birthdate, dateNow).getYears();

        return ResponseEntity.ok("age: " + age);
    }
}
