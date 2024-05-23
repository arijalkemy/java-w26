package com.prendas.controllers;

import com.prendas.DTOs.request.SaleRequestDto;
import com.prendas.services.IVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sale")
public class VentaController {

    private final IVentaService ventaService;

    @PostMapping()
    public ResponseEntity<?> createSale(@RequestBody SaleRequestDto saleRequestDto) {
        return ResponseEntity.ok(ventaService.crear(saleRequestDto));
    }

    @GetMapping
    public ResponseEntity<?> findAllSales(
            @RequestParam(required = false, name = "date") @DateTimeFormat(
                    pattern = "dd/MM/yyyy"
            ) LocalDate date
    ) {
        return new ResponseEntity<>(
                date == null ? ventaService.getAll(): ventaService.findByDate(date),
                HttpStatus.OK
        );
    }

    @GetMapping("{number}")
    public ResponseEntity<?> findByNumber(@PathVariable("number") Long number) {
        return new ResponseEntity<>(
                ventaService.findByNumber(number),
                HttpStatus.OK
        );
    }

    @PutMapping("{number}")
    public ResponseEntity<?> updateSale(
            @PathVariable("number") Long number, @RequestBody SaleRequestDto saleRequestDto
    ) {
        return new ResponseEntity<>(
                ventaService.update(
                        number,
                        saleRequestDto
                ),
                HttpStatus.OK

        );
    }

    @DeleteMapping("{number}")
    public ResponseEntity<?> deleteByNumber(@PathVariable("number") Long number) {
        ventaService.delete(number);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("clothes/{number}")
    public ResponseEntity<?> findClothesByNumber(@PathVariable Long number) {
        return new ResponseEntity<>(
                ventaService.findClothesByNumber(number),
                HttpStatus.OK
        );
    }

}
