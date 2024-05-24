package org.example.movies_hql.repository;

import org.example.movies_hql.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActorRepository extends JpaRepository<Actor, Integer> {
}
