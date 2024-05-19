package com.w26.miniseries.miniseries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.w26.miniseries.miniseries.model.Miniserie;

@Repository
public interface IMiniserieRepository extends JpaRepository<Miniserie, Long>{

}
