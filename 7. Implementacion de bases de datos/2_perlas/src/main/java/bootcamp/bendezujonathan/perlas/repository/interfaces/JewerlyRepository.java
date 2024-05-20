package bootcamp.bendezujonathan.perlas.repository.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bootcamp.bendezujonathan.perlas.model.Jewerly;

@Repository
public interface JewerlyRepository extends JpaRepository<Jewerly, Long> {
    
    List<Jewerly> findByVentaONo(boolean ventaONo);
    Optional<Jewerly> findByNroIdentificatorioAndVentaONo(long id, boolean ventaONo);
}
