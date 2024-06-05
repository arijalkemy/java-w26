package org.example.testjpahql.service;

import org.example.testjpahql.entity.dto.EpisodeDTO;

import java.util.List;

public interface IEpisodeService {

    List<EpisodeDTO> getEpisodeWithActor(String name, String lastName);
}
