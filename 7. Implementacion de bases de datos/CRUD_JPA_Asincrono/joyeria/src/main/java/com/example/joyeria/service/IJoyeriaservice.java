package com.example.joyeria.service;

import com.example.joyeria.model.Joyeria;

import java.util.List;
public interface IJoyeriaservice {
    public List<Joyeria> getJewerly();
    public void saveJewerly(Joyeria joya);
    public Joyeria editJewerly (Joyeria joya);
    public void deleteJewerly(long nroIdentificatorio);
    public Joyeria findJewerly(long nroIdentificatorio);
}
