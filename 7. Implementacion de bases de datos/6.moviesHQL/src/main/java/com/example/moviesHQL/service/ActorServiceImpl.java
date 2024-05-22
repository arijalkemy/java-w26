package com.example.moviesHQL.service;

import com.example.moviesHQL.dto.ActorDTO;
import com.example.moviesHQL.dto.ActorResponseDTO;
import com.example.moviesHQL.model.Actor;
import com.example.moviesHQL.repository.ActorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements IActorService{

    public ActorRepository actorRepository;
    public ObjectMapper objectMapper = new ObjectMapper();

    public ActorServiceImpl(ActorRepository actorRepository, ObjectMapper objectMapper) {
        this.actorRepository = actorRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<ActorResponseDTO> getAllActors() {
        List<Actor> actors = actorRepository.findAll();
        return actors.stream().map(actor -> objectMapper.convertValue(actor, ActorResponseDTO.class)).toList();
    }

    @Override
    public ActorResponseDTO getActorById(Long id) {
        Actor actor = actorRepository.findById(id).orElse(null);
        return objectMapper.convertValue(actor, ActorResponseDTO.class);
    }

    @Override
    public void saveActor(ActorDTO actorDTO) {
        Actor actor = objectMapper.convertValue(actorDTO, Actor.class);
        actorRepository.save(actor);
    }
}
