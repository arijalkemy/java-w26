package bootcamp.db.movies_hql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bootcamp.db.movies_hql.model.Genre;

public interface GenreRepository extends JpaRepository<Genre,Integer>{
    
}
