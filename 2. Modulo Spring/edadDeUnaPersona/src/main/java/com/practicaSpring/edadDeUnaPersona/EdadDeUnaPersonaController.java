package com.practicaSpring.edadDeUnaPersona;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.Map;

@RestController
public class EdadDeUnaPersonaController {

    private Map<Integer, Integer> diasPorMes = Map.ofEntries(
            new AbstractMap.SimpleEntry<>(1, 31),
            new AbstractMap.SimpleEntry<>(2, 29),
            new AbstractMap.SimpleEntry<>(3, 31),
            new AbstractMap.SimpleEntry<>(4, 30),
            new AbstractMap.SimpleEntry<>(5, 31),
            new AbstractMap.SimpleEntry<>(6, 30),
            new AbstractMap.SimpleEntry<>(7, 31),
            new AbstractMap.SimpleEntry<>(8, 31),
            new AbstractMap.SimpleEntry<>(9, 30),
            new AbstractMap.SimpleEntry<>(10, 31),
            new AbstractMap.SimpleEntry<>(11, 30),
            new AbstractMap.SimpleEntry<>(12, 31)
    );

    @GetMapping("/{dia}/{mes}/{año}")
    public String getEdadDeUnaPersona(@PathVariable int dia, @PathVariable int mes, @PathVariable int año) {
        LocalDate curDate = LocalDate.now();
        if (curDate.getYear() < año || (curDate.getYear() == año && curDate.getMonth().getValue() < mes)
                || (curDate.getYear() == año && curDate.getMonth().getValue() == mes && curDate.getDayOfMonth() < dia)
                || !diasPorMes.containsKey(mes) || dia < 0 || dia > diasPorMes.get(mes) || (mes == 2 && dia == 29 && año % 4 != 0)) {
            return "Error: " + dia + "/" + mes + "/" + año + " no es una fecha válida";
        }
        LocalDate given = LocalDate.of(curDate.getYear(), mes, dia);
        return String.valueOf((curDate.getYear() - año) - (given.isAfter(curDate) ? 1 : 0));
    }
}
