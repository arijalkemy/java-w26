package com.example.movies_db.service.Impl;

import com.example.movies_db.dto.ActorDTO;
import com.example.movies_db.entity.Actor;
import com.example.movies_db.repository.IActorRepository;
import com.example.movies_db.service.IActorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements IActorService {

    private final IActorRepository actorRepository;


    @Override
    public List<ActorDTO> getAllActors() {
        ModelMapper modelMapper = new ModelMapper();
        List<Actor> actors = actorRepository.findAll().stream().toList();
        List<ActorDTO> actorDTOS = actors.stream()
                .map(actor -> modelMapper.map(actor, ActorDTO.class)).toList();
        return actorDTOS;
    }
}
