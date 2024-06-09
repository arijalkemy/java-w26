package org.example.dto_p1_sports.service.interfaces;

import org.example.dto_p1_sports.entity.Sport;
import org.example.dto_p1_sports.dto.SportDTO;

import java.util.List;

public interface ISportService {
    List<Sport> getAllSports();
    String getSportLevel(String name);
    List<SportDTO> getPersonSport();
}
