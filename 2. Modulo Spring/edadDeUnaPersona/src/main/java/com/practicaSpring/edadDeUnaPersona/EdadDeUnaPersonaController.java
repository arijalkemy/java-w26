package com.practicaSpring.edadDeUnaPersona;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.DateTimeException;
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
    public ResponseEntity<Integer> getEdadDeUnaPersona(@PathVariable int dia, @PathVariable int mes, @PathVariable int año) {
        LocalDate curDate = LocalDate.now();
        LocalDate given;
        try{
            given = LocalDate.of(año, mes, dia);
            if(given.isAfter(curDate)){
                throw new DateTimeException("La fecha introducida es futura");
            }
        } catch (DateTimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(given.until(curDate).getYears(), HttpStatus.OK);
    }
}
