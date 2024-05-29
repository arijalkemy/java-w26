package com.w26.seguros_autos.seguros_autos.service;

import com.w26.seguros_autos.seguros_autos.mediator.dto.PostVehiculo;
import com.w26.seguros_autos.seguros_autos.mediator.dto.SuccesfullyResponse;

public interface IVehiculoService {
    SuccesfullyResponse createVehiculo(PostVehiculo vehiculo);
    SuccesfullyResponse retriveAllVehiculo(); 
    SuccesfullyResponse retrivePatenteAllVehiculo();
    SuccesfullyResponse retrivePatenteAndMarca();
    SuccesfullyResponse retriePatenteByActualFabricacion();
    SuccesfullyResponse retriveMajorPerdidaEconomica();
    SuccesfullyResponse retriveMajorPerdidaEconomicaAndTotal();
}
