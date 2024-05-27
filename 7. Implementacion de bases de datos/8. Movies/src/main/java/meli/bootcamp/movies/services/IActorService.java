package meli.bootcamp.movies.services;

import meli.bootcamp.movies.DTOs.ActorDTO;

import java.util.List;

public interface IActorService {
    public List<ActorDTO> getActoresWithFavoriteMovie();
    public List<ActorDTO> getActoresWithRatingGreaterThan(Double rating);
    public List<ActorDTO> getActoresByPeliculaId(Long peliculaId);
}
