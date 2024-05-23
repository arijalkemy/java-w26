package com.crudpractice.movies.service.implementation;

import com.crudpractice.movies.dto.ActorDTO;
import com.crudpractice.movies.dto.EpisodeDTO;
import com.crudpractice.movies.dto.MovieDTO;
import com.crudpractice.movies.dto.SerieDTO;
import com.crudpractice.movies.entity.Actor;
import com.crudpractice.movies.entity.Episode;
import com.crudpractice.movies.entity.Movie;
import com.crudpractice.movies.entity.Serie;
import com.crudpractice.movies.repository.*;
import com.crudpractice.movies.service.IMoviesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import static com.crudpractice.movies.util.MoviesUtils.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MoviesServiceImpl implements IMoviesService {
    private final IActorRepository actorRepository;
    private final IEpisodeRepository episodeRepository;
    private final IGenreRepository genreRepository;
    private final IMovieRepository movieRepository;
    private final ISeasonRepository seasonRepository;
    private final ISerieRepository serieRepository;


    @Override
    public List<ActorDTO> showActorsWithFavMovies(){
        List<Actor> actors = this.actorRepository.findActorsByFavoriteMovieNotNull();
        return getActorsDTO(actors);
    }


    @Override
    public List<ActorDTO> showActorsWithRatingGreaterThan(Double rating) {
        List<Actor> actors = this.actorRepository.findActorsByRatingGreaterThan(rating);
        return getActorsDTO(actors);
    }

    @Override
    public List<ActorDTO> showActorsThatAppearInMovie(String movie) {
        List<Actor> actors = this.actorRepository.findActorsByMovies_TitleContaining(movie);
        return getActorsDTO(actors);
    }

    @Override
    public List<MovieDTO> showMoviesByActorRating(Double rating) {
        List<Movie> movies = this.movieRepository.findMoviesByActorsInMovie_RatingGreaterThan(rating);
        return getMoviesDTO(movies);
    }

    @Override
    public List<MovieDTO> showMoviesByGenre(String genre) {
        List<Movie> movies = this.movieRepository.findMovisByGenre_NameContaining(genre);
        return getMoviesDTO(movies);
    }

    @Override
    public List<SerieDTO> showSeriesBySeasons(int seasons) {
        List<Serie> series = this.serieRepository.findBySeasons_NumberOfSeasonGreaterThan(seasons);
        return getSeriesDTO(series);
    }

    @Override
    public List<EpisodeDTO> showEpisodesByActors(String actor) {
        List<Episode> episodes = this.episodeRepository.findEpisodesByActors(actor);
        return getEpisodesDTO(episodes);
    }


}
