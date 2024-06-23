package org.example.siniestrovehicle.service;

import java.util.HashMap;
import java.util.List;

public interface IVehicleService {
    List<HashMap<String, Object>> getAllPatentes();

    List<HashMap<String, Object>> getAllPatentesMarcaOrder();

    List<HashMap<String, Object>> getAllPatenteAnioFabricacion();
}
