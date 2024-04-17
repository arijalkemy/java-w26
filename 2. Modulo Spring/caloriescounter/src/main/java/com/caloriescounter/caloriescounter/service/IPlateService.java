package com.caloriescounter.caloriescounter.service;

import java.util.List;

import com.caloriescounter.caloriescounter.dto.PlateDto;
import com.caloriescounter.caloriescounter.model.Plate;

public interface IPlateService {
    public List<Plate> getAllPlates();
    public PlateDto getPlateInformation(String plate, int weight);
}
