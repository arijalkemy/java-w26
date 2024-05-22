package org.implementaciondb.ejercicio5_movies_hql.mapper;

import org.implementaciondb.ejercicio5_movies_hql.model.dto.ActorDto;
import org.implementaciondb.ejercicio5_movies_hql.model.dto.FavoriteMovieActorDto;
import org.implementaciondb.ejercicio5_movies_hql.model.entity.Actor;

public class ActorMapper {

    public static ActorDto convertToDto(Actor actor) {
        FavoriteMovieActorDto fmad;
        if (actor.getFavoriteMovie() == null) {
            fmad = null;
        } else {
            fmad = FavoriteMovieActorDto.builder()
                    .id(actor.getFavoriteMovie().getId())
                    .title(actor.getFavoriteMovie().getTitle())
                    .rating(actor.getFavoriteMovie().getRating())
                    .awards(actor.getFavoriteMovie().getAwards())
                    .releaseDate(actor.getFavoriteMovie().getReleaseDate())
                    .length(actor.getFavoriteMovie().getLength())
                    .build();
        }
        return ActorDto.builder()
                .id(actor.getId())
                .firstName(actor.getFirstName())
                .lastName(actor.getLastName())
                .rating(actor.getRating())
                .favoriteMovie(fmad)
                .build();
    }

}
