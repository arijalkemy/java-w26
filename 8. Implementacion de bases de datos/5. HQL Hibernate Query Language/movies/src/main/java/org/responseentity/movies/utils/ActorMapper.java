package org.responseentity.movies.utils;

import org.responseentity.movies.dto.ActorDTO;
import org.responseentity.movies.dto.ActorWithFavoriteMovieDTO;
import org.responseentity.movies.dto.MovieDTO;
import org.responseentity.movies.model.Actor;

public class ActorMapper {
    public static ActorDTO entityToDto(Actor entity){
        return ActorDTO.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .build();
    }

    public static ActorWithFavoriteMovieDTO entityToActorWithFavoriteMovie(Actor entity){
        MovieDTO movieDto = MovieMapper.entityToDto(entity.getFavoriteMovie());

        return ActorWithFavoriteMovieDTO.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .movieDTO(movieDto)
                .build();
    }
}
