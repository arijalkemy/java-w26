package bootcamp.bendezujonathan.cloth.service.interfaces;

import bootcamp.bendezujonathan.cloth.dto.request.ClothRequest;
import bootcamp.bendezujonathan.cloth.dto.response.ClothResponse;
import bootcamp.bendezujonathan.cloth.model.Cloth;

import java.util.List;

public interface ClothService {

    void create(ClothRequest request);
    void batch(List<ClothRequest> requests);
    void update(Long codigo, ClothRequest request);
    void delete(Long codigo);
    ClothResponse findById(Long id);
    List<ClothResponse> findAll();
    List<ClothResponse> findAllBySize(String size);
    List<ClothResponse> findAllByName(String name);
    Cloth findModelById(Long id);
    ClothResponse modelToResponse(Cloth cloth);


}
