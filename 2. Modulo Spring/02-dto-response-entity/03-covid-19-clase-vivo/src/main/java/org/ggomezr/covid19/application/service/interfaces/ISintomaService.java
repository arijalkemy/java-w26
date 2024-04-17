package org.ggomezr.covid19.application.service.interfaces;

import org.ggomezr.covid19.domain.entity.Sintoma;

import java.util.List;

public interface ISintomaService {
    List<Sintoma> findAllSymptoms();
    String findSymptom(String name);
}
