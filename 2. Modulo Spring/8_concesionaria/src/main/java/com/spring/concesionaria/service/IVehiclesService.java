package com.spring.concesionaria.service;

import com.spring.concesionaria.dto.VehicleDTO;

import java.util.List;

public interface IVehiclesService {

    VehicleDTO findById(Integer id);

    List<VehicleDTO> findBetweenDates(String since, String to);

    List<VehicleDTO> findBetweenPrices(String since, String to);

    List<VehicleDTO> findAll();

    void create(VehicleDTO vehicle);

}
