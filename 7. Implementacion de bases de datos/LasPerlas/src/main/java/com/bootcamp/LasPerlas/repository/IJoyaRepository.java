package com.bootcamp.LasPerlas.repository;
import com.bootcamp.LasPerlas.model.Joya;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyaRepository extends JpaRepository <Joya, Long> {
    List<Joya> findByVentaONo(boolean ventaONo);
}
