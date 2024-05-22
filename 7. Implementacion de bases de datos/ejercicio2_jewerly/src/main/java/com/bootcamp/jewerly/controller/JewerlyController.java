package com.bootcamp.jewerly.controller;

import com.bootcamp.jewerly.dto.JewerlyDTO;
import com.bootcamp.jewerly.dto.ResponseDTO;
import com.bootcamp.jewerly.service.IJewerlyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JewerlyController {

    private final IJewerlyService jewerlyService;

    public JewerlyController(IJewerlyService jewerlyService) {
        this.jewerlyService = jewerlyService;
    }

    @GetMapping
    public ResponseEntity<List<JewerlyDTO>> getJewerly() {
        return ResponseEntity.ok().body(jewerlyService.getAll());
    }

    @PostMapping("/new")
    public ResponseEntity<ResponseDTO> createJewerly(@RequestBody JewerlyDTO jewerlyDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jewerlyService.create(jewerlyDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteJewerly(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(jewerlyService.delete(id));
    }

    @PutMapping("/update")
    public ResponseEntity<JewerlyDTO> updateJewerly(@RequestBody JewerlyDTO jewerlyDTO) {
        return ResponseEntity.ok().body(jewerlyService.update(jewerlyDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<JewerlyDTO> getJewerlyById(@PathVariable long id) {
        return ResponseEntity.ok().body(jewerlyService.getById(id));
    }
}
