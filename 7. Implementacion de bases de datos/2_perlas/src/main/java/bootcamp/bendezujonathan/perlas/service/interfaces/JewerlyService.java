package bootcamp.bendezujonathan.perlas.service.interfaces;

import java.util.List;

import bootcamp.bendezujonathan.perlas.dto.request.JewerlyRequest;
import bootcamp.bendezujonathan.perlas.dto.response.JewerlyResponse;
import bootcamp.bendezujonathan.perlas.dto.response.MessageResponse;

public interface JewerlyService {
    MessageResponse create(JewerlyRequest toCreate);
    MessageResponse delete(long id);
    List<JewerlyResponse> findAll();
    JewerlyResponse findById(long id);
    void update(long id, JewerlyRequest toUpdate);
}
