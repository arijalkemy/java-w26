package bootcamp.bendezujonathan.cloth.service.interfaces;


import bootcamp.bendezujonathan.cloth.dto.request.SaleRequest;
import bootcamp.bendezujonathan.cloth.dto.response.ClothResponse;
import bootcamp.bendezujonathan.cloth.dto.response.SaleResponse;
import bootcamp.bendezujonathan.cloth.model.Cloth;

import java.time.LocalDate;
import java.util.List;

public interface SaleService {

    void create(SaleRequest request);
    void delete(Long id);
    void update(Long id, SaleRequest request);
    List<SaleResponse> findAll();
    SaleResponse findById(Long id);
    List<SaleResponse> findByDate(LocalDate date);
    List<ClothResponse> findAllBySale(Long id);
}
