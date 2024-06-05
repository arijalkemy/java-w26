package org.example.testjpahql.service;

import org.example.testjpahql.entity.dto.ActorDTO;

import java.math.BigDecimal;
import java.util.List;

public interface IActorService {
    List<ActorDTO> getActorsWithFavouriteMovie();
    List<ActorDTO> getActorsWithRatingGreaterThan(BigDecimal decimal);
    List<ActorDTO> getActorsInMovie(String title);
}
