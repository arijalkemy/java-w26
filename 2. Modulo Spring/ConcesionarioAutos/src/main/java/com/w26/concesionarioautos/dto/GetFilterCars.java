package com.w26.concesionarioautos.dto;

import com.w26.concesionarioautos.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetFilterCars {
    private List<Car> carList;
}
