package clave.compuesta.controller;

import clave.compuesta.dto.CompraRequestDto;
import clave.compuesta.service.ICompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CompraController {

    private final ICompraService compraService;

    @PostMapping("/add")
    public ResponseEntity<?> newCompra(@RequestBody CompraRequestDto compraRequestDto) {
        return new ResponseEntity<>(compraService.saveCompra(compraRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> allCompras() {
        return new ResponseEntity<>(compraService.findAll(), HttpStatus.OK);
    }


}
