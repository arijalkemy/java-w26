package org.miprimerproyecto.practicahql.service.imp;

import org.miprimerproyecto.practicahql.repository.episodeRepository;
import org.miprimerproyecto.practicahql.service.IepisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class episodeService implements IepisodeService {

    @Autowired
    private episodeRepository episodeRepository;

    @Override
    public List<String> findEpisodesByActor(String actor) {
        return episodeRepository.findEpisodesByActor(actor);
    }
}
