package bootcamp.bendezujonathan.hql.service.implementations;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import bootcamp.bendezujonathan.hql.dto.response.ActorMovieResponse;
import bootcamp.bendezujonathan.hql.dto.response.ActorResponse;
import bootcamp.bendezujonathan.hql.model.Actor;
import bootcamp.bendezujonathan.hql.repository.interfaces.ActorRepository;
import bootcamp.bendezujonathan.hql.service.interfaces.ActorService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {

    private ModelMapper mapper;
    private final ActorRepository repository;

    @PostConstruct
    public void init() {
        mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    @Override
    public List<ActorResponse> findAllWithFavMovie() {
        return repository.findAllWithFavMovie()
            .stream()
            .map(this::modelToResponse)
        .toList();
    }

    @Override
    public List<ActorResponse> findAllOverRating(double rating) {
        return repository.findAllOverRating(rating)
        .stream()
        .map(this::modelToResponse)
        .toList();
    }

    @Override
    public List<ActorMovieResponse> findActorByMovie(String movie) {
        return repository.findAllByMovie(movie)
        .stream()
        .map(this::modelToMovieResponse)
        .toList();
    }

    private ActorResponse modelToResponse(Actor model) {
        return mapper.map(model, ActorResponse.class);
    }

    private ActorMovieResponse modelToMovieResponse(Actor model) {
        return mapper.map(model, ActorMovieResponse.class);
    }

 

    
}
