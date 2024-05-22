package meli.bootcamp.hql.repository;

import java.util.List;
import meli.bootcamp.hql.model.Siniestro;
import meli.bootcamp.hql.projection.PatenteMarcaModeloView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ISiniestrosRepository extends JpaRepository<Siniestro, Long> {
    @Query("SELECT s.vehiculoDenunciado.patente as patente, s.vehiculoDenunciado.marca as marca, " +
        "s.vehiculoDenunciado.modelo as modelo FROM Siniestro s WHERE s.perdidaEconomica > 10000")
    List<PatenteMarcaModeloView> findAllPerdidasMayoresA10000();

    @Query("SELECT sum(s.perdidaEconomica) FROM Siniestro s WHERE s.perdidaEconomica > 10000 ")
    Double findTotalEnPerdidasMayoresA10000();
}
