package org.example.integradorconcessionaire.repository;


import java.util.UUID;

public interface IVehicleRepository <V, T>{

    public String add(V v);
    public T retreatInfo(UUID id);

}
