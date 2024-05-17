package practica.Miniseries.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practica.Miniseries.Entity.MiniSerie;

@Repository
public interface IMiniserieRepository extends JpaRepository<MiniSerie, Long> {
}
