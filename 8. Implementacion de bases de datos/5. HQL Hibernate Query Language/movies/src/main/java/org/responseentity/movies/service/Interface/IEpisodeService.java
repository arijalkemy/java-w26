package org.responseentity.movies.service.Interface;

import org.responseentity.movies.dto.EpisodeDTO;

import java.util.List;

public interface IEpisodeService {
    List<EpisodeDTO> listAllEpisodesByActor(String firstName, String lastName);
}
