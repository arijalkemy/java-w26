package org.miprimerproyecto.practicahql.repository;

import org.miprimerproyecto.practicahql.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface genreRepository extends CrudRepository<Genre,Long> {
    List<Genre> findAll();
}
