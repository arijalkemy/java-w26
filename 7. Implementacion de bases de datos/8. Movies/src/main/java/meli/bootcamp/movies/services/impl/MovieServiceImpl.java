package meli.bootcamp.movies.services.impl;

import meli.bootcamp.movies.DTOs.MovieDTO;
import meli.bootcamp.movies.Repositories.IMovieRepository;
import meli.bootcamp.movies.models.Movie;
import meli.bootcamp.movies.services.IMovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {

    private final IMovieRepository movieRepository;

    public MovieServiceImpl(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDTO> getPeliculasByActoresConRatingMayorQue(Double rating) {
        return this.mapListMovieToMovieDTO(this.movieRepository.getMoviesWithActoresWithRatingGreaterThan(rating));
    }

    @Override
    public List<MovieDTO> getPeliculasByGenero(Long generoId) {
        return mapListMovieToMovieDTO(this.movieRepository.findByGenreId(generoId));
    }

    @Override
    public List<String> getSeriesByTemporadasGreaterThan(Integer cantTemporadas) {
        return List.of();
    }

    @Override
    public List<String> getEpisodiosByActor(String actor) {
        return List.of();
    }

    private List<MovieDTO> mapListMovieToMovieDTO(List<Movie> movies) {
        return movies
                .stream()
                .map(movie -> new MovieDTO(movie.getId(),
                        movie.getCreatedAt(),
                        movie.getUpdatedAt(),
                        movie.getTitle(),
                        movie.getRating(),
                        movie.getAwards(),
                        movie.getReleaseDate(),
                        movie.getLength(),
                        movie.getGenre() != null ? movie.getGenre().getId() : null
                        ))
                .toList();
    }
}
