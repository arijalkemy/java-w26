package org.miprimerproyecto.practicahql.service;

import java.util.List;

public interface IseriesService {
    List<String> findSeriesWithSeasonsGreaterThan(Integer seasons);
}
