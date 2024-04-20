package com.w26.linktracker.service;

import com.w26.linktracker.dto.LinkMetricsCalls;
import org.springframework.http.ResponseEntity;

public interface IGetMetricsLink {

    LinkMetricsCalls getMetricsById(Integer id);


}
