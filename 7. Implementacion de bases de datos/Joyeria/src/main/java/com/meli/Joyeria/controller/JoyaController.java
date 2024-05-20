package com.meli.Joyeria.controller;

import com.meli.Joyeria.dto.CreateResponseDto;
import com.meli.Joyeria.dto.JoyaDto;
import com.meli.Joyeria.model.Joya;
import com.meli.Joyeria.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/jewerly")
public class JoyaController {

    @Autowired
    private IJoyaService joyaService;

    @PostMapping("/new")
    private ResponseEntity<CreateResponseDto> createJoya(@RequestBody JoyaDto joya){
        return new ResponseEntity<>(joyaService.createJoya(joya), HttpStatus.CREATED);
    }

    @GetMapping("/")
    private ResponseEntity<List<JoyaDto>> getAllJoya(){
        return ResponseEntity.ok(joyaService.getAllJoya());
    }

    @DeleteMapping("/delete/{id})")
    private void deleteJoya(@PathVariable Long id){
        joyaService.deleteJoya(id);
    }

    @PatchMapping("/update/{id}")
    private ResponseEntity<JoyaDto> updateJoya(@PathVariable Long id, @RequestBody JoyaDto joya){
        return ResponseEntity.ok(joyaService.updateJoya(id, joya));
    }
}
