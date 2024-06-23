package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.Location;

public interface IDistanceService {
    Double getDistanceBetweenTwoLocations(Location location1, Location location2);
}
