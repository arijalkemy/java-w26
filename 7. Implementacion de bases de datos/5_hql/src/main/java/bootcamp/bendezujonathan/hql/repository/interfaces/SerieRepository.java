package bootcamp.bendezujonathan.hql.repository.interfaces;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bootcamp.bendezujonathan.hql.model.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {
    
    @Query("SELECT s FROM Serie s join s.seasons WHERE SIZE(s.seasons) > :cantTemp")
    List<Serie> findByCantSeaons(@Param("cantTemp") int cantTemp);

    
}
