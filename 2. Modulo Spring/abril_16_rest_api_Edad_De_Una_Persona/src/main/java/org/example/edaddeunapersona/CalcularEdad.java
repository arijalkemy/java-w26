package org.example.edaddeunapersona;

import org.example.edaddeunapersona.models.UserData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcularEdad {
    @GetMapping("/{day}/{month}/{year}")
    public int index(@PathVariable String day, @PathVariable String month, @PathVariable String year) {
        UserData userData = new UserData(year, month, day);
        return userData.calculateAge();
    }
}

