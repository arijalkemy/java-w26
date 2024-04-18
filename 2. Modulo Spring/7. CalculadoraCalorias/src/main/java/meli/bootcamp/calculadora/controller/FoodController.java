package meli.bootcamp.calculadora.controller;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.calculadora.dto.FoodDto;
import meli.bootcamp.calculadora.service.FoodImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/food")
public class FoodController {

    private final FoodImpl food;

    @GetMapping("/search")
    public ResponseEntity<List<FoodDto>> getFoodByName(@RequestParam String ... names) {
        System.out.println(Arrays.toString(names));
        return ResponseEntity.ok(food.findFood(names));
    }
}
