package ageApi.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/converter")
public class AgeConverterController {
    @Autowired
    IAgeConverter converter;

    @GetMapping("/{day}/{mont}/{year}")
    public String dateToAge(@PathVariable Integer day, @PathVariable Integer mont, @PathVariable Integer year){
        return converter.toAge(day, mont, year);
    }
}
