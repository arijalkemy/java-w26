package com.w26.concesionarioautos.dto;

import com.w26.concesionarioautos.entity.Car;
import com.w26.concesionarioautos.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetCarFull {
    private Car car;
    private List<Service> serviceList;
}
