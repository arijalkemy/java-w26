package org.responseentity.movies.service.Interface;

import org.responseentity.movies.dto.MovieDTO;

import java.util.List;

public interface IMovieService {
    List<MovieDTO> listMoviesByGenre(String genre);
}
