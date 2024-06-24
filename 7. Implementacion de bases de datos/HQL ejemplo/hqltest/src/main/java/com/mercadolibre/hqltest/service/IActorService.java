package com.mercadolibre.hqltest.service;

import com.mercadolibre.hqltest.model.Actor;

import java.util.List;

public interface IActorService {
    List<Actor> findAllActors();
}
