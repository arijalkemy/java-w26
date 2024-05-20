package bootcamp.base.miniseries.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bootcamp.base.miniseries.model.MiniSerie;

@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {
    
}
