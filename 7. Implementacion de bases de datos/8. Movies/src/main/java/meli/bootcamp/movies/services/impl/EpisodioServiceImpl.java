package meli.bootcamp.movies.services.impl;

import meli.bootcamp.movies.DTOs.EpisodeDTO;
import meli.bootcamp.movies.Repositories.IEpisodioRepository;
import meli.bootcamp.movies.models.Episode;
import meli.bootcamp.movies.services.IEpisodiosService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodioServiceImpl implements IEpisodiosService {

    private final IEpisodioRepository episodioRepository;

    public EpisodioServiceImpl(IEpisodioRepository episodioRepository) {
        this.episodioRepository = episodioRepository;
    }

    @Override
    public List<EpisodeDTO> getEpisodiosByActor(Long actorId) {
        return this.convertListEpisodesToListEpisodesDTO(this.episodioRepository.findAllEpisodesByActorId(actorId));
    }

    private List<EpisodeDTO> convertListEpisodesToListEpisodesDTO(List<Episode> episodes) {
        return episodes
                .stream()
                .map(episode -> new EpisodeDTO(
                        episode.getId(),
                        episode.getCreatedAt(),
                        episode.getUpdatedAt(),
                        episode.getTitle(),
                        episode.getNumber(),
                        episode.getReleaseDate(),
                        episode.getRating(),
                        episode.getSeason() != null ? episode.getSeason().getId() : null
                ))
                .toList();
    }
}
