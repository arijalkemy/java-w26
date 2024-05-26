package org.responseentity.lasperlas.repository;

import org.responseentity.lasperlas.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewerlyRepository extends JpaRepository<Jewel, Long> {
}
