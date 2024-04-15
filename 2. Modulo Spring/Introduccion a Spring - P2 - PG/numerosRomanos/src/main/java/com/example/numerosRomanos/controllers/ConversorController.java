package com.example.numerosRomanos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversorController {

    @GetMapping("{number}")
    public String transformNumber(@PathVariable Integer number) {
        StringBuilder romanNumber = new StringBuilder();
        while (number > 0) {
            if (number >= 1000) {
                number -= 1000;
                romanNumber.append("M");
                continue;
            }
            if (number >= 900) {
                number -= 900;
                romanNumber.append("CM");
                continue;
            }
            if (number >= 500) {
                number -= 500;
                romanNumber.append("D");
                continue;
            }
            if (number >= 400) {
                number -= 400;
                romanNumber.append("CD");
                continue;
            }
            if (number >= 100) {
                number -= 100;
                romanNumber.append("C");
                continue;
            }
            if (number >= 90) {
                number -= 90;
                romanNumber.append("XC");
                continue;
            }
            if (number >= 50) {
                number -= 50;
                romanNumber.append("L");
                continue;
            }
            if (number >= 40) {
                number -= 40;
                romanNumber.append("XL");
                continue;
            }
            if (number >= 10) {
                number -= 10;
                romanNumber.append("X");
                continue;
            }
            if (number >= 9) {
                number -= 9;
                romanNumber.append("IX");
                continue;
            }
            if (number >= 5) {
                number -= 5;
                romanNumber.append("V");
                continue;
            }
            if (number >= 4) {
                number -= 4;
                romanNumber.append("IV");
                continue;
            }
            number -= 1;
            romanNumber.append("I");
        }
        return romanNumber.toString();
    }
}
