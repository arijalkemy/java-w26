package org.responseentity.jpa_demo.repository;

import org.responseentity.jpa_demo.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnimalRepository extends JpaRepository<Animal, Long> {
}


