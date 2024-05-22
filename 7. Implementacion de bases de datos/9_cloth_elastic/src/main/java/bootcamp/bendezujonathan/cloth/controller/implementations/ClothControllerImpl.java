package bootcamp.bendezujonathan.cloth.controller.implementations;

import bootcamp.bendezujonathan.cloth.controller.interfaces.ClothController;
import bootcamp.bendezujonathan.cloth.dto.request.ClothRequest;
import bootcamp.bendezujonathan.cloth.dto.response.ClothResponse;
import bootcamp.bendezujonathan.cloth.service.interfaces.ClothService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClothControllerImpl implements ClothController {

    private  final ClothService service;

    @Override
    public ResponseEntity<List<ClothResponse>> getAll() {
        return listToResponse(service.findAll());
    }

    @Override
    public ResponseEntity<ClothResponse> getById(String id) {
        ClothResponse res = service.findById(id);
        return ResponseEntity.ok(res);
    }

    @Override
    public ResponseEntity<List<ClothResponse>> getAllBySize(String size) {
        return  listToResponse(service.findAllBySize(size));
    }

    @Override
    public ResponseEntity<List<ClothResponse>> getAllByName(String name) {
        return listToResponse(service.findAllByName(name));
    }

    @Override
    public ResponseEntity<Void> postCloth(ClothRequest req) {
        service.create(req);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @Override
    public ResponseEntity<Void> postBatchCloth(List<ClothRequest> req) {
        service.batch(req);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @Override
    public ResponseEntity<Void> putCloth(String id, ClothRequest req) {
        service.update(id, req);
        return ResponseEntity.noContent()
                .build();
    }

    @Override
    public ResponseEntity<Void> deleteCloth(String id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }


    private ResponseEntity<List<ClothResponse>> listToResponse(List<ClothResponse> res) {
        return ResponseEntity.ok(res);
    }
}
