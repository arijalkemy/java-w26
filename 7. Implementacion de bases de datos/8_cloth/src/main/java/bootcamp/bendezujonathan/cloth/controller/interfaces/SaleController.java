package bootcamp.bendezujonathan.cloth.controller.interfaces;

import bootcamp.bendezujonathan.cloth.dto.request.SaleRequest;
import bootcamp.bendezujonathan.cloth.dto.response.ClothResponse;
import bootcamp.bendezujonathan.cloth.dto.response.SaleResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/sales")
public interface SaleController {

    @PostMapping
    ResponseEntity<Void> postSale(@RequestBody  SaleRequest request);

    @GetMapping
    ResponseEntity<List<SaleResponse>> getAll();

    @GetMapping("/{id}")
    ResponseEntity<SaleResponse> getById(@PathVariable long id);

    @GetMapping(value = "", params = "date")
    ResponseEntity<List<SaleResponse>> getAllByDate(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate date);

    @GetMapping("/{id}/clothes")
    ResponseEntity<List<ClothResponse>> getAllClothOfSale(@PathVariable long id);

    @PutMapping("/{id}")
    ResponseEntity<Void> putSale(@PathVariable long id, @RequestBody SaleRequest request);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteSale(@PathVariable long id);


}
