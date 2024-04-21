package com.example.concesionariaautos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    private String date;
    private Integer kilometer;
    private String description;

}
