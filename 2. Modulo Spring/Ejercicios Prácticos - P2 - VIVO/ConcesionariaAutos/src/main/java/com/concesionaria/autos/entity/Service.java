package com.concesionaria.autos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Service {
    private String date;
    private int kilometers;
    private String descriptions;
}
