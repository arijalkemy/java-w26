package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.impl;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.Location;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces.IDistanceService;
import org.springframework.stereotype.Service;

@Service
public class DistanceServiceImpl implements IDistanceService {

    public Double getDistanceBetweenTwoLocations(Location location1, Location location2) {
        double lat1rad = Math.toRadians(location1.getLatitude());
        double lon1rad = Math.toRadians(location1.getLongitude());
        double lat2rad = Math.toRadians(location2.getLatitude());
        double lon2rad = Math.toRadians(location2.getLongitude());

        double difLatitud = lat1rad - lat2rad;
        double difLongitud = lon1rad - lon2rad;

        double a = Math.pow(Math.sin(difLatitud/2), 2) +
                Math.cos(lat1rad) *
                        Math.cos(lat2rad) *
                        Math.pow(Math.sin(difLongitud/2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        double radioTierraKm = 6378.0;
        double distancia = radioTierraKm * c;

        return distancia;

    }

}
