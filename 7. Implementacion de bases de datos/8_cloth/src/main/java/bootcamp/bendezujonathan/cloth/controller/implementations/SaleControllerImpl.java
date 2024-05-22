package bootcamp.bendezujonathan.cloth.controller.implementations;


import bootcamp.bendezujonathan.cloth.controller.interfaces.SaleController;
import bootcamp.bendezujonathan.cloth.dto.request.SaleRequest;
import bootcamp.bendezujonathan.cloth.dto.response.ClothResponse;
import bootcamp.bendezujonathan.cloth.dto.response.SaleResponse;
import bootcamp.bendezujonathan.cloth.service.interfaces.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SaleControllerImpl  implements SaleController  {

    private  final SaleService service;


    @Override
    public ResponseEntity<Void> postSale(SaleRequest request) {
        service.create(request);
        return ResponseEntity.ok()
                .build();
    }

    @Override
    public ResponseEntity<List<SaleResponse>> getAll() {
        return toResEntity(service.findAll());
    }

    @Override
    public ResponseEntity<SaleResponse> getById(long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<List<SaleResponse>> getAllByDate(LocalDate date) {
        return toResEntity(service.findByDate(date));
    }

    @Override
    public ResponseEntity<List<ClothResponse>> getAllClothOfSale(long id) {
        return ResponseEntity.ok(service.findAllBySale(id));
    }

    @Override
    public ResponseEntity<Void> putSale(long id, SaleRequest request) {
        service.update(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

    @Override
    public ResponseEntity<Void> deleteSale(long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

    private ResponseEntity<List<SaleResponse>> toResEntity(List<SaleResponse> res) {
        return ResponseEntity.ok(res);
    }
}
