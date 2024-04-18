package org.mercadolibre.multicapatemplate.controller;

import org.mercadolibre.multicapatemplate.dto.DishResponseDTO;
import org.mercadolibre.multicapatemplate.service.impl.DishServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DishController {

    DishServiceImpl dishService;

    public DishController(DishServiceImpl dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/food/{dishName}")
    public ResponseEntity<DishResponseDTO> getDishInfo(@PathVariable String dishName){
        return new ResponseEntity<>(this.dishService.getDishInfo(dishName), HttpStatus.OK);
    }


}
