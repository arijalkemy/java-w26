package bootcamp.bendezujonathan.perlas.controller.implementations;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.bendezujonathan.perlas.controller.interfaces.JewerlyController;
import bootcamp.bendezujonathan.perlas.dto.request.JewerlyRequest;
import bootcamp.bendezujonathan.perlas.dto.response.JewerlyResponse;
import bootcamp.bendezujonathan.perlas.dto.response.MessageResponse;
import bootcamp.bendezujonathan.perlas.service.interfaces.JewerlyService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class JewerlyControllerImpl implements JewerlyController {

    private final JewerlyService service;

    @Override
    public ResponseEntity<MessageResponse> postJwerly(JewerlyRequest req) {
        MessageResponse response = service.create(req);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<JewerlyResponse>> getAll() {
        List<JewerlyResponse> responses = service.findAll();
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<JewerlyResponse> getById(long id) {
        JewerlyResponse response = service.findById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> updateJewerly(long id, JewerlyRequest req) {
        service.update(id, req);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<MessageResponse> deleteJewerly(long id) {
        MessageResponse response = service.delete(id);
        return ResponseEntity.ok(response);
    }
    
}
