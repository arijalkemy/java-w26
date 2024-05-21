package bootcamp.db.movies_hql.service;

import java.util.List;

import bootcamp.db.movies_hql.model.Serie;

public interface SerieService {
    List<Serie> searchAll();

    Serie searchByTitle(String title);
}
