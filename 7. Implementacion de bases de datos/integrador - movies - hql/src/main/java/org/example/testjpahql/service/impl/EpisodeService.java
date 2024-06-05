package org.example.testjpahql.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.testjpahql.entity.Episode;
import org.example.testjpahql.entity.dto.EpisodeDTO;
import org.example.testjpahql.repository.IEpisodeRepository;
import org.example.testjpahql.service.IEpisodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeService implements IEpisodeService {

    private final IEpisodeRepository episodeRepository;
    private final ObjectMapper objectMapper;

    private EpisodeDTO mapToEntity(Episode episode){
        return objectMapper.convertValue(episode, EpisodeDTO.class);
    };

    @Override
    public List<EpisodeDTO> getEpisodeWithActor(String name, String lastName) {
        return episodeRepository.getEpisodeWithActor(name, lastName).stream().map(this::mapToEntity).toList();
    }

}
