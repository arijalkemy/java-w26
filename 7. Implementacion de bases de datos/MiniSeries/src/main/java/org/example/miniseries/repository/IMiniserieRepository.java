package org.example.miniseries.repository;

import org.example.miniseries.entity.Miniserie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository extends JpaRepository<Miniserie, Long> {
}
