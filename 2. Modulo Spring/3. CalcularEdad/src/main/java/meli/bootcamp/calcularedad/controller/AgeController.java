package meli.bootcamp.calcularedad.controller;

import meli.bootcamp.calcularedad.service.interfaces.ICalculateAge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeController {

    private final ICalculateAge calculateAge;

    public AgeController(ICalculateAge calculateAge) {
        this.calculateAge = calculateAge;
    }

    @GetMapping("/{day}/{month}/{year}")
    public Integer showAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {
        return calculateAge.fromDate(year, month, day);
    }
}
