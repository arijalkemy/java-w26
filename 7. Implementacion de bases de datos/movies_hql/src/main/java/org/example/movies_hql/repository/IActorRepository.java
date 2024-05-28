package org.example.movies_hql.repository;

import org.example.movies_hql.model.ActorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActorRepository extends JpaRepository<ActorsEntity, Integer> {
}
