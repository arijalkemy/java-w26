package com.meli.ejercicioenvivovehiculo.repository;

import com.meli.ejercicioenvivovehiculo.model.Vehicule;

import java.time.LocalDate;
import java.util.List;

public interface IVehiculeRepository {
    List<Vehicule> getVehicules();

    Vehicule findById(int id);

    void addVehicule(Vehicule vehicule);

    List<Vehicule> findByDateCreation(LocalDate dateInitial, LocalDate dateFinal);

    List<Vehicule> findByPrice(int since, int to);
}
