package com.example.concesionariaauto.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class ServiceEntity {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private int kilometers;
    private String descriptions;
}
