package org.example.dtosport.service;

import org.example.dtosport.entity.Sport;

import java.util.List;

public interface ISport {
    Sport findByName(String name);
    List<Sport> findAll();
}
