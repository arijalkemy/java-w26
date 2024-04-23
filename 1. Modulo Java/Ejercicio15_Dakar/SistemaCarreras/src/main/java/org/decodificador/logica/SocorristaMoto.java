package org.decodificador.logica;

public class SocorristaMoto implements ISocorristaVehiculo{
    @Override
    public void socorrerVehiculo(Vehiculo vehiculo){
        System.out.println("Socorriendo Moto....");
        System.out.println("Con patente: "+vehiculo.getPatente());
    }
}
