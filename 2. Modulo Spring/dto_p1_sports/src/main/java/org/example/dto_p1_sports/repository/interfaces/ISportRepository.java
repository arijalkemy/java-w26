package org.example.dto_p1_sports.repository.interfaces;

import org.example.dto_p1_sports.entity.Sport;

import java.util.List;

public interface ISportRepository {
    List<Sport> findAll();
    Sport findByName(String name);
}
