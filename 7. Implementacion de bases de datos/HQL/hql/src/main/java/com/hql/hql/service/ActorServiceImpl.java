package com.hql.hql.service;

import com.hql.hql.model.Actor;
import com.hql.hql.repository.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ActorServiceImpl implements IActorService{
    @Autowired
    IActorRepository actorRepository;

    @Override
    public ArrayList<Actor> findActorByRatingGreaterThan(int rating) {
        return (ArrayList<Actor>) actorRepository.findActorByRatingGreaterhan(rating);
    }

    @Override
    public ArrayList<Actor> findActorByMovieName(String movieName) {
        return (ArrayList<Actor>) actorRepository.findActorsByMovieName(movieName);
    }

    @Override
    public ArrayList<Actor> findActorByFavoriteMovieNotNull() {
        return (ArrayList<Actor>) actorRepository.findActorByFavoriteMovieNotNull();
    }
}
