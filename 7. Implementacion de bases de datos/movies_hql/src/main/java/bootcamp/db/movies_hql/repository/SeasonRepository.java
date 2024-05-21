package bootcamp.db.movies_hql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bootcamp.db.movies_hql.model.Season;

public interface SeasonRepository extends JpaRepository<Season,Integer>{
    
}
