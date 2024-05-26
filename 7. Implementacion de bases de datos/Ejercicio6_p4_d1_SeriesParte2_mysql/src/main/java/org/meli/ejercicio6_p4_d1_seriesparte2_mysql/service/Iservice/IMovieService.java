package org.meli.ejercicio6_p4_d1_seriesparte2_mysql.service.Iservice;

import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.dto.MovieDto;

import java.util.List;

public interface IMovieService {
    public List<MovieDto> getAllMoviesGenres(String genre);
}
