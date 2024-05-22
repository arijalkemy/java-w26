package com.meli.miniseries.Repository;

import com.meli.miniseries.Model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long>{
    
}
