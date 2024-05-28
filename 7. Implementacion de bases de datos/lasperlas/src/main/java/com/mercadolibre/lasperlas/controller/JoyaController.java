package com.mercadolibre.lasperlas.controller;

import com.mercadolibre.lasperlas.dto.JoyaRequestDTO;
import com.mercadolibre.lasperlas.model.Joya;
import com.mercadolibre.lasperlas.service.IJoyaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "jewerly")
public class JoyaController {

    private final IJoyaService joyaServ;

    @PostMapping
    public ResponseEntity<Void> saveJoya(@RequestBody JoyaRequestDTO joya) {
        joyaServ.saveJoya(joya);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Joya> getJoyas() {
        return joyaServ.getJoyas();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteJoya(@PathVariable Long id) {
        joyaServ.deleteJoya(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id_modificar}")
    public ResponseEntity<Void> editJoya(@PathVariable("id_modificar") Long idModificar, @RequestBody JoyaRequestDTO joya) {
        joyaServ.editJoya(idModificar, joya);
        return ResponseEntity.noContent().build();
    }


}
