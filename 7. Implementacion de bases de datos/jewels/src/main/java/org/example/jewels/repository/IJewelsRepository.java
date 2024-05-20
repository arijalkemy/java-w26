package org.example.jewels.repository;

import org.example.jewels.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelsRepository extends JpaRepository<Jewel, Long> {
}
