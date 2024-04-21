package com.w26.concesionarioautos.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarServices {
    private Car car;
    private List<Service> serviceList = new ArrayList<>();
}
