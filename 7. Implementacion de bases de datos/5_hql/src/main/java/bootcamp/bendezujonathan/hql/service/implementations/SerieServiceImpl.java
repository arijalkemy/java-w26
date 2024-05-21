package bootcamp.bendezujonathan.hql.service.implementations;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import bootcamp.bendezujonathan.hql.dto.response.SerieResponse;
import bootcamp.bendezujonathan.hql.model.Serie;
import bootcamp.bendezujonathan.hql.repository.interfaces.SerieRepository;
import bootcamp.bendezujonathan.hql.service.interfaces.SerieService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SerieServiceImpl implements SerieService {
 
    private ModelMapper mapper;
    private final SerieRepository repository;

    @PostConstruct
    public void init() {
        mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    @Override
    public List<SerieResponse> findAllByCantSeason(int cantSeason) {
        return repository.findByCantSeaons(cantSeason)
        .stream()
        .map(this::modelToResponse)
        .toList();
    }


    private SerieResponse modelToResponse(Serie model) {
        return mapper.map(model, SerieResponse.class);
    }

}
