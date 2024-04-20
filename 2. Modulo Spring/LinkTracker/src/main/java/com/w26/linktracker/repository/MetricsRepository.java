package com.w26.linktracker.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Getter
public class MetricsRepository {

    private Map<Integer, Integer> callsLinks;

    public MetricsRepository()
    {
        callsLinks = new HashMap<>();
    }

    public Integer getMetricsLinkById(Integer idLink)
    {
        return callsLinks.get(idLink);
    }
    public void addTraceToLink(Integer idLink) {
        this.callsLinks.put(idLink, 0);
    }

    public Integer aumentCallsMetricsById(Integer idLink) {

        Integer value = this.callsLinks.get(idLink);

        if (value != null) {
            this.callsLinks.put(idLink, value + 1);
        }

        return value;
    }

    public Integer getTraceLink(Integer idLink){
        return this.callsLinks.get(idLink);
    }
}
