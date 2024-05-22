package bootcamp.bendezujonathan.cloth.service.interfaces;

import bootcamp.bendezujonathan.cloth.dto.request.ClothRequest;
import bootcamp.bendezujonathan.cloth.dto.response.ClothResponse;
import bootcamp.bendezujonathan.cloth.model.Cloth;

import java.util.List;

public interface ClothService {

    void create(ClothRequest request);
    void batch(List<ClothRequest> requests);
    void update(String codigo, ClothRequest request);
    void delete(String codigo);
    ClothResponse findById(String id);
    List<ClothResponse> findAll();
    List<ClothResponse> findAllBySize(String size);
    List<ClothResponse> findAllByName(String name);
    Cloth findModelById(String id);
    ClothResponse modelToResponse(Cloth cloth);


}
