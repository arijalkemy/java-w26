package org.example;

public class Socorrista implements ISocorrista{
    @Override
    public void socorrer(Vehiculo vehiculo) {
        System.out.println("Socorriendo " + vehiculo.getTipoVehiculo().name().toLowerCase() +" con la patente: " + vehiculo.getPatente());
    }
}
