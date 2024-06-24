package com.mercadolibre.hqltest.service;

import com.mercadolibre.hqltest.model.Actor;
import com.mercadolibre.hqltest.repository.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService{

    @Autowired
    IActorRepository repository;


    @Override
    public List<Actor> findAllActors() {
        return repository.findAllActor();
    }
}
