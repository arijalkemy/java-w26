package com.bootcamp.hqlmovies.service;

import com.bootcamp.hqlmovies.model.dto.ActorDTO;
import com.bootcamp.hqlmovies.repository.ActorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements IActorService {
    private final ActorRepository actorRepository;
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<ActorDTO> getAllActorsWithAFavoriteMovie() {
        return actorRepository.findAllWithAFavoriteMovie().stream().map(
                a -> mapper.convertValue(a, ActorDTO.class)
        ).toList();
    }
}
