package com.demospring.practicahql.service.impl;

import com.demospring.practicahql.repository.IEpisodeRepository;
import com.demospring.practicahql.service.IEpisodeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EpisodeService implements IEpisodeService {
    private final IEpisodeRepository episodeRepository;

    @Override
    public List<String> findEpisodesByActorName(String firstName, String lastName) {
        return episodeRepository.findEpisodesByActorName(firstName, lastName);
    }
}
