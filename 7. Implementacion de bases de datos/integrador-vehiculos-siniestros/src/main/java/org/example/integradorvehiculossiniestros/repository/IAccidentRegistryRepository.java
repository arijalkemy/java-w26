package org.example.integradorvehiculossiniestros.repository;

import org.example.integradorvehiculossiniestros.entity.AccidentRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccidentRegistryRepository extends JpaRepository<AccidentRegistry, Integer> {

}
