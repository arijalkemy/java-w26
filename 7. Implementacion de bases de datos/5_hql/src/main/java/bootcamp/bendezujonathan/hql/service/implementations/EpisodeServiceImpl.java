package bootcamp.bendezujonathan.hql.service.implementations;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import bootcamp.bendezujonathan.hql.dto.response.EpisodeResponse;
import bootcamp.bendezujonathan.hql.model.Episode;
import bootcamp.bendezujonathan.hql.repository.interfaces.EpisodeRepository;
import bootcamp.bendezujonathan.hql.service.interfaces.EpisodeService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EpisodeServiceImpl implements EpisodeService {
    
    private ModelMapper mapper;
    private final EpisodeRepository repository;

    @PostConstruct
    public void init() {
        mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    @Override
    public List<EpisodeResponse> findAllByActor(String actorName) {
        return repository.findByActorName(actorName)
        .stream()
        .map(this::modelToResponse)
        .toList();
    }


    private EpisodeResponse modelToResponse(Episode ep) {
        return mapper.map(ep, EpisodeResponse.class);
    }

}
