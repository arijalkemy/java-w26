package com.w26.movies.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.w26.movies.demo.entity.Actor;
import com.w26.movies.demo.repository.IActorRepository;
import com.w26.movies.demo.service.interfaces.IActorService;



@Service
public class ActorService implements IActorService {

    @Autowired
    IActorRepository actorRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public List<Actor> findActorsByNotNullFavoriteMoview() {
        List<Actor> actorsComplex = actorRepository.findByfavoriteMovieIsNotNull();
        System.out.println(actorsComplex);
        //List<ActorDTO> actorsPOJO = actorsComplex.stream().map(a -> objectMapper.convertValue(a, ActorDTO.class))
                //.toList();
        return actorsComplex;
    }

    @Override
    public List<Actor> findAll() {
        List<Actor> actorsComplex = actorRepository.findAll();
        
        //objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //List<Actor> actorsPOJO = actorsComplex.stream().map(a -> objectMapper.convertValue(a, ActorDTO.class))
                //.toList();
        return actorsComplex;
    }

    @Override
    public List<Actor> findBySuperiorRatingThan(BigDecimal rating) {
        List<Actor> actorsComplex = actorRepository.findByratingIsGreaterThan(rating);

        //objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //List<Actor> actorsPOJO = actorsComplex.stream().map(a -> objectMapper.convertValue(a, ActorDTO.class))
                //.toList();
        return actorsComplex;
    }

}
