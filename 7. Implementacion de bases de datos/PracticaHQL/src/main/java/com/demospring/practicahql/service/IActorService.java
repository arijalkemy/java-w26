package com.demospring.practicahql.service;

import com.demospring.practicahql.model.Actor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface IActorService {
    List<String> findActorsWithOneFavoriteMovie();
    List<String> findActorsByRatingOver(double rating);
    List<String> findActorsByMovieName(String title);
}
