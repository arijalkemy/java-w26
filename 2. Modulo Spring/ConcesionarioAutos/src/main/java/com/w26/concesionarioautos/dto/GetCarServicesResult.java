package com.w26.concesionarioautos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetCarServicesResult {
    private String message;
    private List<CarServices> cars;
}
