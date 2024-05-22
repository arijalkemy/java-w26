package bootcamp.bendezujonathan.cloth.repository.interfaces;

import bootcamp.bendezujonathan.cloth.model.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothRepository extends JpaRepository<Cloth, Long> {


    List<Cloth> findAll();
    List<Cloth> findAllByNombreContaining(String name);
    List<Cloth> findAllByTalle(String talle);


}
