package com.hql.hql.service;

import com.hql.hql.model.Actor;

import java.util.ArrayList;

public interface IActorService {

    ArrayList<Actor> findActorByRatingGreaterThan(int rating );
    ArrayList<Actor> findActorByMovieName(String movieName );
    ArrayList<Actor> findActorByFavoriteMovieNotNull();
}
