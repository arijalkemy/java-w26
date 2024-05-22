package org.ggomezr.movies.application.service.interfaces;

import java.util.List;

public interface ISerieService {
    List<String> getAllSeriesWithMoreThanSeasons(Integer seasons);
    List<String> findAllSeriesWhereTitleIs(String title);
}
