package org.miprimerproyecto.practicahql.service.imp;

import org.miprimerproyecto.practicahql.repository.actorRepository;
import org.miprimerproyecto.practicahql.service.IactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class actorService implements IactorService {

    @Autowired
    private actorRepository actorRepository;

    @Override
    public List<String> findActorsWithFavoriteMovie() {
        return actorRepository.findActorsWithFavoriteMovie();
    }

    @Override
    public List<String> findActorsWithRatingGreaterThan(Double rating) {
        return actorRepository.findActorsWithRatingGreaterThan(rating);
    }

    @Override
    public List<String> findActorsByMovieTitle(String title) {
        return actorRepository.findActorsByMovieTitle(title);
    }
}
