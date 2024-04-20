package com.w26.linktracker.service;

import com.w26.linktracker.dto.LinkMetricsCalls;
import com.w26.linktracker.exception.RetriveLinkException;
import com.w26.linktracker.repository.MetricsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetMetricsLinkImpl implements IGetMetricsLink {

    final MetricsRepository metricsRepository;

    public GetMetricsLinkImpl(MetricsRepository metricsRepository)
    {
        this.metricsRepository = metricsRepository;
    }

    @Override
    public LinkMetricsCalls getMetricsById(Integer id) {

        Integer metricsCalls = this.metricsRepository.getMetricsLinkById(id);

        if (metricsCalls == null)
            throw new RetriveLinkException("No se pudo recuperar las metricas del link, porfavor valdie su id", id);

        LinkMetricsCalls response = new LinkMetricsCalls(id, metricsCalls, "Estadisticas encontradas");

        return response;
    }
}
