package bootcamp.bendezujonathan.hql.service.interfaces;

import java.util.List;

import bootcamp.bendezujonathan.hql.dto.response.SerieResponse;

public interface SerieService {
    
    List<SerieResponse> findAllByCantSeason(int cantSeason);

}
