package org.example.rest_http_p1_age_calcs.ages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeController {
    @Autowired
    AgesService agesService;

    @GetMapping("/{day}/{month}/{year}")
    public String greeting(@PathVariable Integer day,
                           @PathVariable Integer month,
                           @PathVariable Integer year) {
        return agesService.calcAge(day, month, year);
    }
}
