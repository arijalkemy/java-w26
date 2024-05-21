package com.example.movieshqlasync.service;

import com.example.movieshqlasync.dto.response.ActorResponseDto;
import com.example.movieshqlasync.repository.IActorRepository;
import com.example.movieshqlasync.utils.ActorMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActorService implements IActorService{
    @Autowired
    IActorRepository iActorRepository;

    @Override
    public List<ActorResponseDto> getActorsWithFavoriteMovie() {
        return ActorMapper.mapToListResponseDto(iActorRepository.findAllByFavoriteMovieIsNotNull());
    }

    @Override
    public List<ActorResponseDto> getActorsWithHighRating(Double rating) {
        return ActorMapper.mapToListResponseDto(iActorRepository.findAllByRatingGreaterThanEqual(rating));
    }

    @Override
    public List<ActorResponseDto> getActorsByMovie(Integer movieId) {
        return ActorMapper.mapToListResponseDto(iActorRepository.findAllByMovieId(movieId));
    }

    @Override
    public ActorResponseDto getActorById(Integer id) {
        return new ModelMapper().map(iActorRepository.findActorById(id), ActorResponseDto.class);
    }
}
