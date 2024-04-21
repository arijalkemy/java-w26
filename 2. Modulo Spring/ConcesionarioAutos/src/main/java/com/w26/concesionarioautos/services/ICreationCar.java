package com.w26.concesionarioautos.services;

import com.w26.concesionarioautos.dto.CarServices;
import com.w26.concesionarioautos.dto.CreationCarResult;

public interface ICreationCar {

    CreationCarResult createCar(CarServices carServices);
}
