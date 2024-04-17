package com.caloriescounter.caloriescounter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caloriescounter.caloriescounter.dto.PlateDto;
import com.caloriescounter.caloriescounter.model.Plate;
import com.caloriescounter.caloriescounter.service.IPlateService;

@RestController
@RequestMapping("/api/calories")
public class PlateController {

    @Autowired
    IPlateService plateService;
    
    @GetMapping("/{plate}/{weight}")
    public PlateDto getPlateInformation(@PathVariable String plate, @PathVariable int weight){
        return plateService.getPlateInformation(plate, weight); 
    }

    @GetMapping("/getall")
    public List<Plate> getAllPlates(){
        return plateService.getAllPlates();
    }
}
