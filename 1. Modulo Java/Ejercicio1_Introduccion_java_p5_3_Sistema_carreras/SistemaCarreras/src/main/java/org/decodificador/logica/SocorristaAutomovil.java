package org.decodificador.logica;

public class SocorristaAutomovil implements ISocorristaVehiculo{
    @Override
    public void socorrerVehiculo(Vehiculo vehiculo){
        System.out.println("Socorriendo Automovil....");
        System.out.println("Con patente: "+vehiculo.getPatente());
    }
}
