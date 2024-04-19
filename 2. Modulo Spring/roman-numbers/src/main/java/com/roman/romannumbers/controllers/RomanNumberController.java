package com.roman.romannumbers.controllers;

import com.roman.romannumbers.services.IRomanNumberService;
import com.roman.romannumbers.services.impl.IRomanNumberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/roman")
public class RomanNumberController {

    private final IRomanNumberService romanNumberService;

    @Autowired
    public RomanNumberController(IRomanNumberService romanNumberService) {
        this.romanNumberService = romanNumberService;
    }

    @GetMapping("/{number}")
    public String getParsedNumber(@PathVariable int number){
        return romanNumberService.parseNumber(number);
    }
}
