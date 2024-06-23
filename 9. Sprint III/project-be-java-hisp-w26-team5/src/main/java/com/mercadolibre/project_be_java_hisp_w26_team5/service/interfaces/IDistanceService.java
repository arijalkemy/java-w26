package com.mercadolibre.project_be_java_hisp_w26_team5.service.interfaces;

import com.mercadolibre.project_be_java_hisp_w26_team5.model.Location;

public interface IDistanceService {
    Double getDistanceBetweenTwoLocations(Location location1, Location location2);
}
