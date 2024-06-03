package com.bootcamp.hqlmovies.service;

import com.bootcamp.hqlmovies.model.Actor;
import com.bootcamp.hqlmovies.model.dto.ActorDTO;
import com.bootcamp.hqlmovies.model.dto.MovieDTO;
import com.bootcamp.hqlmovies.repository.ActorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ActorServiceImpl implements IActorService {
    private final ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    private final ModelMapper mapper = new ModelMapper();

    private List<ActorDTO> mapActorEntityToDTO(List<Actor> actors) {
        return actors.stream().map(
                a -> mapper.map(a, ActorDTO.class)
        ).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActorDTO> getAllActorsWithAFavoriteMovie() {
        return mapActorEntityToDTO(actorRepository.findAllWithRatingGreaterThan());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActorDTO> getAllActorsWithRatingGreaterThan(Double rating) {
        return mapActorEntityToDTO(actorRepository.findAllWithRatingGreaterThan(rating));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActorDTO> getAllActorsInMovie(String movieTitle) {
        return mapActorEntityToDTO(actorRepository.findAllInMovie(movieTitle));
    }
}
