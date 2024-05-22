package com.example.moviesHQL.service;

import com.example.moviesHQL.dto.ActorDTO;
import com.example.moviesHQL.dto.ActorResponseDTO;

import java.util.List;

public interface IActorService {

    List<ActorResponseDTO> getAllActors();
    ActorResponseDTO getActorById(Long id);
    void saveActor(ActorDTO actorDTO);
}
