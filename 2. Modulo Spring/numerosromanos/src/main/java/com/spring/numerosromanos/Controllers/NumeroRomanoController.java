package com.spring.numerosromanos.Controllers;


import com.spring.numerosromanos.Services.NumeroRomanoService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumeroRomanoController {
    @Autowired
    private NumeroRomanoService numRomanoService;

    @GetMapping("{number}")
    public String intToRomano(@PathVariable @Positive int number) {
        return numRomanoService.intToRomano(number);
    }

}
