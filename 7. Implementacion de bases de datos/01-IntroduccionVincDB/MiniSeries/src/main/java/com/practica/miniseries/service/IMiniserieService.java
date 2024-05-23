package com.practica.miniseries.service;

import com.practica.miniseries.model.MiniSerie;

import java.util.List;

public interface IMiniserieService {
    public List<MiniSerie> getSeries();
    public void saveSerie(MiniSerie miniSerie);
    public void deleteSerie(long id);
    public MiniSerie findSerie(long id);
}
