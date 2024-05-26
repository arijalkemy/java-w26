package ejercicio.Crud.Repository;
import ejercicio.Crud.Entity.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IJewelRepository extends JpaRepository<Jewel, Long
        > {
    Optional<Jewel> findById(Long id);
    List<Jewel> findAll();
}
