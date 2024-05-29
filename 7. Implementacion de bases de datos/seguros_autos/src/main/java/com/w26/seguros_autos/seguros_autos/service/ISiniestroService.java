package com.w26.seguros_autos.seguros_autos.service;

import com.w26.seguros_autos.seguros_autos.mediator.dto.PostSiniestro;
import com.w26.seguros_autos.seguros_autos.mediator.dto.SuccesfullyResponse;

public interface ISiniestroService {
    SuccesfullyResponse createSiniestro(Long idVehiculo, PostSiniestro siniestro);
    SuccesfullyResponse retriveAllSiniestro();
}
