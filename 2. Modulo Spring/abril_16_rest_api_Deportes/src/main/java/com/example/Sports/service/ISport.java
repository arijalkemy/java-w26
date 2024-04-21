package com.example.Sports.service;

import com.example.Sports.entity.Sport;

import java.util.List;

public interface ISport {
    public List<Sport> findAll();
    public Sport findByName(String name);
}
