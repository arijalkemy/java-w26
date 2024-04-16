package com.ej2p1.athletes.services;

import com.ej2p1.athletes.model.Sport;

import java.util.List;

public interface ISportsViewer {
    List<Sport> findAllSports();
    String findSportLevelByName(String sportName);
}
