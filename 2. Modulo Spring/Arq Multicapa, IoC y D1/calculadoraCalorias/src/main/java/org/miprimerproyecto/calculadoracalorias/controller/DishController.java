package org.miprimerproyecto.calculadoracalorias.controller;

import org.miprimerproyecto.calculadoracalorias.dto.DishDTO;
import org.miprimerproyecto.calculadoracalorias.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DishController {
    @Autowired
    DishService dishService;

    @GetMapping("/dish/{name}/{weigth}")
    ResponseEntity<?> getDish(@PathVariable String name, @PathVariable int weigth){
        return new ResponseEntity<>(dishService.getDish(name, weigth), HttpStatus.OK);
    }
}
