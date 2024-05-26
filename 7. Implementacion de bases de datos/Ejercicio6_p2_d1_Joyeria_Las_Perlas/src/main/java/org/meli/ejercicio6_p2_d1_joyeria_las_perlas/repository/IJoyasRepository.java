package org.meli.ejercicio6_p2_d1_joyeria_las_perlas.repository;

import org.meli.ejercicio6_p2_d1_joyeria_las_perlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyasRepository extends JpaRepository<Joya, Long> {
}
