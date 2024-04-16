package com.example.deportistas.service;

import com.example.deportistas.model.Deporte;

import java.util.List;

public interface IDeporte {

    public List<Deporte> TodoDeportes();

    public int verDeporte(String nombre);
}
