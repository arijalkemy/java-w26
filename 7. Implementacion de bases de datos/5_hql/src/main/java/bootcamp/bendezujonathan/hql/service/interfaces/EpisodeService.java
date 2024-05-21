package bootcamp.bendezujonathan.hql.service.interfaces;

import java.util.List;

import bootcamp.bendezujonathan.hql.dto.response.EpisodeResponse;

public interface EpisodeService {
    
    List<EpisodeResponse> findAllByActor(String actorName);

}
