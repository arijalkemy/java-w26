package com.meli.lasperlas.controller;

import com.meli.lasperlas.dto.NewJewellResponseDTO;
import com.meli.lasperlas.dto.RequestJewellDTO;
import com.meli.lasperlas.dto.RequestUpdateJewellDTO;
import com.meli.lasperlas.dto.ResponseJewellDTO;
import com.meli.lasperlas.service.IJewellService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewellry")
@RequiredArgsConstructor
public class JewellryController {

    private final IJewellService jewellService;

    @PostMapping("/new")
    public ResponseEntity<NewJewellResponseDTO> save(@RequestBody RequestJewellDTO requestJewellDTO) {
        return new ResponseEntity<>(jewellService.saveJewell(requestJewellDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseJewellDTO>> getAll() {
        return new ResponseEntity<>(jewellService.getJewells(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        jewellService.deleteJewell(id);
        return new ResponseEntity<>("deleted", HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<?> update(
            @PathVariable Long id_modificar,
            @RequestBody RequestUpdateJewellDTO requestUpdateJewellDTO) {
        return new ResponseEntity<>(
                jewellService.update(id_modificar, requestUpdateJewellDTO),
                HttpStatus.ACCEPTED);
    }

}
