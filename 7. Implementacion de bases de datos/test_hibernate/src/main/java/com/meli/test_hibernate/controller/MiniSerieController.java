package com.meli.test_hibernate.controller;

import com.meli.test_hibernate.model.MiniSerie;
import com.meli.test_hibernate.service.MiniSerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mini_serie")
public class MiniSerieController {
    private final MiniSerieService miniSerieService;

    @PostMapping
    public String addUser(@RequestBody MiniSerie student){

        return miniSerieService.addMiniSerie(student);
    }
}
