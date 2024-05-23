package com.demospring.joyerialasperlas.repository;

import com.demospring.joyerialasperlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJoyaRepository extends JpaRepository<Joya, Long> {
    @Query(value = "SELECT j FROM Joya j WHERE j.ventaONo = :ventaONo", nativeQuery = true)
    List<Joya> findAllByVentaONo(@Param("ventaONo") boolean ventaONo);
}
