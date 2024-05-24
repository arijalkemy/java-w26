package com.bootcamp.vehiculo.service;

import com.bootcamp.vehiculo.dto.SiniestroDTO;

public interface ISiniestroService {

    SiniestroDTO save(Long vehiculoID, SiniestroDTO siniestroDTO);

}
