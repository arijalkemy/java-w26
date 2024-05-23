package org.miprimerproyecto.practicahql.service;

import java.util.List;

public interface IepisodeService {
    List<String> findEpisodesByActor(String actor);
}
