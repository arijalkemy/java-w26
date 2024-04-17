package com.edad.persona.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
public class Edad {

    @GetMapping("/edad/{dia}/{mes}/{anio}")
    public int edad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        Calendar ahora = Calendar.getInstance();
        int anioActual = ahora.get(Calendar.YEAR);
        int mesActual = ahora.get(Calendar.MONTH) + 1;
        int diaActual = ahora.get(Calendar.DAY_OF_MONTH);

        int edad = anioActual - anio;

        if (mesActual < mes || (mesActual == mes && diaActual < dia)) {
            edad--;
        }
        return edad;
    }
}
