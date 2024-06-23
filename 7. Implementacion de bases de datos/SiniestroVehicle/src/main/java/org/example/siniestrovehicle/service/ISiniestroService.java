package org.example.siniestrovehicle.service;

import java.util.HashMap;
import java.util.List;

public interface ISiniestroService {

    List<HashMap<String, Object>> getSiniestroMoreThat10000();
    List<HashMap<String, Object>> getSiniestroPerdidaMoreThat10000();
}
