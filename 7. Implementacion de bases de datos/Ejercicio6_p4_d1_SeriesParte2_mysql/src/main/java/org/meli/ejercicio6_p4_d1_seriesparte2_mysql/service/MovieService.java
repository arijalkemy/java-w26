package org.meli.ejercicio6_p4_d1_seriesparte2_mysql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.dto.MovieDto;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.repository.IMovieRepository;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.service.Iservice.IMovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieService implements IMovieService {
    private IMovieRepository movieRepository;
    private ObjectMapper objectMapper;

    @Override
    @Transactional
    public List<MovieDto> getAllMoviesGenres(String genre) {
        return movieRepository.findByGenre(genre)
                .stream()
                .map(v -> objectMapper.convertValue(v, MovieDto.class))
                .collect(Collectors.toList());

    }
}
