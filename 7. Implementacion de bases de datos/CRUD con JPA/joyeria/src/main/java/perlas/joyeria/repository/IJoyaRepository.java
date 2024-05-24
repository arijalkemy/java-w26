package perlas.joyeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import perlas.joyeria.model.Joya;

@Repository
public interface IJoyaRepository extends JpaRepository<Joya, Long> {
}
