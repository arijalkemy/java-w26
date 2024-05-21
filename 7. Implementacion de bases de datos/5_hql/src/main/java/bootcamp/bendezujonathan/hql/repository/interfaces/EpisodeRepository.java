package bootcamp.bendezujonathan.hql.repository.interfaces;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bootcamp.bendezujonathan.hql.model.Episode;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {
    

    @Query("SELECT e FROM Episode e join e.actors a where a.firstName = :actorName")
    List<Episode> findByActorName(@Param(value = "actorName") String name);


}
