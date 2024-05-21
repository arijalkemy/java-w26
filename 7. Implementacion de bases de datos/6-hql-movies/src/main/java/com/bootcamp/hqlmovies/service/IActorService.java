package com.bootcamp.hqlmovies.service;

import com.bootcamp.hqlmovies.model.dto.ActorDTO;

import java.util.List;

public interface IActorService {
    public List<ActorDTO> getAllActorsWithAFavoriteMovie();
}
