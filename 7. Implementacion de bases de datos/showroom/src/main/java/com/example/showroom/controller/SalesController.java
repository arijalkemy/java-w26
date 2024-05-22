package com.example.showroom.controller;

import com.example.showroom.dto.request.SaleRequestDTO;
import com.example.showroom.dto.response.ClothDTO;
import com.example.showroom.dto.response.MessageDTO;
import com.example.showroom.dto.response.SaleDTO;
import com.example.showroom.entity.Sale;
import com.example.showroom.service.ISalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api/sale")
@RequiredArgsConstructor
public class SalesController {
    private final ISalesService salesService;

    @PostMapping()
    public ResponseEntity<MessageDTO> addNewSale(@RequestBody SaleRequestDTO newSale){
        MessageDTO message = salesService.addNewSale(newSale);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<List<SaleDTO>> getAllSales(){
        return new ResponseEntity<>(salesService.getSales(),HttpStatus.OK);
    }

    @GetMapping("/{date }")
    public ResponseEntity<List<SaleDTO>> getSalesByDate(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate date) {
        return ResponseEntity.ok().body(salesService.getSalesByDate(date));
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<MessageDTO> deleteSale(
            @PathVariable Long number
    ) {
        salesService.deleteSale(number);
        return new ResponseEntity<>(
                MessageDTO.builder().message("Sale deleted successfully.").build(),
                HttpStatus.OK
        );
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<ClothDTO>> getClothesOfSale(
            @PathVariable Long saleNumber
    ) {
        return new ResponseEntity<>(
          salesService.searchClothesOfSale(saleNumber),
          HttpStatus.OK
        );
    }

    @GetMapping("/{number}")
    public ResponseEntity<SaleDTO> getSaleByNumber(@PathVariable Long number){
        SaleDTO sale = salesService.showSaleByNumber(number);
        return ResponseEntity.ok().body(sale);
    }

    @GetMapping()
    public ResponseEntity<List<ClothDTO>> getClothesSoldByDate(@RequestParam LocalDate date){
        List<ClothDTO> clothes = salesService.showClothesByDate(date);
        return ResponseEntity.ok().body(clothes);
    }
}
