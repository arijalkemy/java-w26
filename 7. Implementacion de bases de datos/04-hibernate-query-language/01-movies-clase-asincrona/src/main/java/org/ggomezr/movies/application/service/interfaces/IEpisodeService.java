package org.ggomezr.movies.application.service.interfaces;

import java.util.List;

public interface IEpisodeService {
    List<String> getAllEpisodesWhereActorIsPresent(String actor);
    List<String> getAllEpisodesWhichRatingIsGreaterThan(Float rating);
}
