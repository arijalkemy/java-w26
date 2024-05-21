package bootcamp.db.movies_hql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bootcamp.db.movies_hql.model.Serie;

public interface SerieRepository extends JpaRepository<Serie,Integer>{
    Serie findSerieByTitle(String title);
}
