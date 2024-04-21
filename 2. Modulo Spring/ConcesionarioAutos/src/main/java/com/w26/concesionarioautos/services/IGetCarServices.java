package com.w26.concesionarioautos.services;

import com.w26.concesionarioautos.dto.GetCarFull;
import com.w26.concesionarioautos.dto.GetCarNotServicesResult;
import com.w26.concesionarioautos.dto.GetCarServicesResult;
import com.w26.concesionarioautos.dto.GetFilterCars;

import java.time.LocalDate;

public interface IGetCarServices {

    GetFilterCars retriveCarNotServices();

    GetCarFull retriveCarById(Integer id);

    GetFilterCars retriveCarByRangeDates(LocalDate since, LocalDate to);

    GetFilterCars retriveCarByRangePrice(Double since, Double to);
}
