package com.example.HQL.service;

import com.example.HQL.dto.response.ActorResponseDto;

import java.util.List;

public interface IActorService {
    List<ActorResponseDto> searchAllThatHaveFavoriteMovie();
    List<ActorResponseDto> searchAllWithRatingAbove(Integer rating);
    List<ActorResponseDto> searchAllWorkingInMovie(String title);
}
