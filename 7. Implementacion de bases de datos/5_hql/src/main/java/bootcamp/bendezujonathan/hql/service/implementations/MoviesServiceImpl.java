package bootcamp.bendezujonathan.hql.service.implementations;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import bootcamp.bendezujonathan.hql.dto.response.MovieResponse;
import bootcamp.bendezujonathan.hql.model.Movie;
import bootcamp.bendezujonathan.hql.repository.interfaces.MovieRepository;
import bootcamp.bendezujonathan.hql.service.interfaces.MoviesService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MoviesServiceImpl implements MoviesService {
    
    private ModelMapper mapper;
    private final MovieRepository repository;

    @PostConstruct
    public void init() {
        mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    @Override
    public List<MovieResponse> findAllByActorsRating(double rating) {
        return repository.findByActorsRating(rating)
        .stream()
        .map(this::modelToResponse)
        .toList();
    }


    private MovieResponse modelToResponse(Movie movie) {
        return mapper.map(movie, MovieResponse.class);
    }

    

}
