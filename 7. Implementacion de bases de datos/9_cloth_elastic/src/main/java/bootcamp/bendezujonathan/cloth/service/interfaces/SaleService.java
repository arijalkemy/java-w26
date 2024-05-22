package bootcamp.bendezujonathan.cloth.service.interfaces;


import bootcamp.bendezujonathan.cloth.dto.request.SaleRequest;
import bootcamp.bendezujonathan.cloth.dto.response.ClothResponse;
import bootcamp.bendezujonathan.cloth.dto.response.SaleResponse;
import bootcamp.bendezujonathan.cloth.model.Cloth;

import java.time.LocalDate;
import java.util.List;

public interface SaleService {

    void create(SaleRequest request);
    void delete(String id);
    void update(String id, SaleRequest request);
    List<SaleResponse> findAll();
    SaleResponse findById(String id);
    List<SaleResponse> findByDate(LocalDate date);
//    List<ClothResponse> findAllBySale(String id);
}
