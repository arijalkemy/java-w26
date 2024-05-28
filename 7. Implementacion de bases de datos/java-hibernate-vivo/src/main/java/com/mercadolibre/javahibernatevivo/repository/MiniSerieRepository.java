package com.mercadolibre.javahibernatevivo.repository;

import com.mercadolibre.javahibernatevivo.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MiniSerieRepository extends JpaRepository<MiniSerie,Long> {
}
