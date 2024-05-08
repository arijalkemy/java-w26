package com.bootcamp.concesionariadeautos.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Service {
    private Date date;
    private int kilometers;
    private String descriptions;

}
