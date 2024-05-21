package com.example.movieshqlasync.utils;

import com.example.movieshqlasync.dto.response.ActorResponseDto;
import com.example.movieshqlasync.model.Actor;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class ActorMapper {

    public static List<ActorResponseDto> mapToListResponseDto(List<Actor> actors){
        List<ActorResponseDto> actorsResponse = new ArrayList<>();

        for (Actor actor : actors){
            actorsResponse.add(mapToResponseDto(actor));
        }

        return actorsResponse;
    }

    public static ActorResponseDto mapToResponseDto(Actor actor){
        return new ModelMapper().map(actor, ActorResponseDto.class);
    }
}
