package com.example.joyeria.controller;

import com.example.joyeria.model.Joyeria;
import com.example.joyeria.repository.IJoyeriaRepositorio;
import com.example.joyeria.service.IJoyeriaservice;
import com.example.joyeria.service.JoyeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class JoyeriaController {
    @Autowired
    private IJoyeriaservice iJoyeriaservice;
    @Autowired
    private JoyeriaService joyeriaService;

    @PostMapping("/jewerly/new")
    public String createJewerly(@RequestBody Joyeria joya){
        iJoyeriaservice.saveJewerly(joya);
        return "nro identificatorio " + joya.getNroIdentificatorio();
    }
    @GetMapping("/jewerly")
    public List<Joyeria> getJewerly(){
        List<Joyeria> joyeriaList = iJoyeriaservice.getJewerly();
        return joyeriaList;
    }
    @PostMapping("/jewerly/update/{nroIdentificatorio}")
    public ResponseEntity<Joyeria> editJewerly(@PathVariable long nroIdentificatorio, @RequestBody Joyeria joya){
        joya.setNroIdentificatorio(nroIdentificatorio);
        Joyeria joy = joyeriaService.editJewerly(joya);
        return ResponseEntity.ok(joy);
    }
}
