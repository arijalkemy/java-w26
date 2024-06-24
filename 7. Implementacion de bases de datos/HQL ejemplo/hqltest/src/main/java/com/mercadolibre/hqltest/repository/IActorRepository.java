package com.mercadolibre.hqltest.repository;

import com.mercadolibre.hqltest.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IActorRepository extends JpaRepository<Actor, Long> {

    @Query("FROM Actor")
    List<Actor> findAllActor();
}
