package com.w26.movies.demo.service.interfaces;

import java.math.BigDecimal;
import java.util.List;

import com.w26.movies.demo.entity.Actor;

public interface IActorService {
    public List<Actor> findActorsByNotNullFavoriteMoview();
    public List<Actor> findAll();
    public List<Actor> findBySuperiorRatingThan(BigDecimal rating); 
}
