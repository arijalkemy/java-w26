package com.mercadolibree.HQL_movies_db.service.actor;

import com.mercadolibree.HQL_movies_db.dto.ActorsResponseDto;

import java.util.List;

public interface IActorService {
    List<ActorsResponseDto> getActorsByAwardsNumber(Double rating);
    List<ActorsResponseDto> getActorsByMovie(String movie);
    List<ActorsResponseDto> getAllActors();
}
