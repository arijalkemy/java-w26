package org.bootcamp.romanos.controller;

import org.springframework.web.bind.annotation.RestController;

import org.bootcamp.romanos.service.IRomanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class RomanosController {
    @Autowired
    IRomanosService romanosService;

    @GetMapping("/toRoman/{num}")
    public String getMethodName(@PathVariable int num) {
        return romanosService.arabicToRoman(num);
    }

    @GetMapping("/toArabic/{num}")
    public int getMethodName(@PathVariable String num) {
        return romanosService.romanToArabic(num);
    }
}
