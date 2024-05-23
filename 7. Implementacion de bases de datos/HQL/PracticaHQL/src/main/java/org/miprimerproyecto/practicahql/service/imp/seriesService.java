package org.miprimerproyecto.practicahql.service.imp;

import org.miprimerproyecto.practicahql.repository.seriesRepository;
import org.miprimerproyecto.practicahql.service.IseriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class seriesService implements IseriesService {

    @Autowired
    private seriesRepository seriesRepository;

    @Override
    public List<String> findSeriesWithSeasonsGreaterThan(Integer seasons) {
        return seriesRepository.findSeriesWithSeasonsGreaterThan(seasons);
    }
}
