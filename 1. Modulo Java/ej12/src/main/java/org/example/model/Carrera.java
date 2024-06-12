package org.example.model;

import java.util.*;

public class Carrera {
    Double distancia;
    Double premioEnDolares;
    String Nombre;
    Integer maxVehiculos;
    List<Vehiculo> listaVehiculos;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer maxVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        Nombre = nombre;
        this.maxVehiculos = maxVehiculos;
        this.listaVehiculos = new ArrayList<Vehiculo>();
    }

    public Boolean darDeAltaVehiculo(Vehiculo vehiculo){
        Boolean boolRes;
        if (listaVehiculos.size() < maxVehiculos){
            listaVehiculos.add(vehiculo);
            boolRes = Boolean.TRUE;
        }else {
            boolRes = Boolean.FALSE;
        }
        return boolRes;

    }
    public void eliminarVehiculo(Vehiculo vehiculo){

    }

    public void eliminarVehiculoConPatente(String patente){

    }

    public String winner(){
        return this.listaVehiculos.stream()
                .filter(Objects::nonNull) // Filtrar para evitar nulls
                .max(Comparator.comparingDouble(Vehiculo::getFormula))
                .map(Vehiculo::getPatente)
                .orElse("No auto");
    }
    public void sendSocorrist(){


        Optional<Vehiculo> socorrista = listaVehiculos.stream().filter(Vehiculo::isSocorrista).findFirst();

        if (socorrista.isPresent()){
            SocorristaAuto superSocorrista = (SocorristaAuto) socorrista.get();

            System.out.println(superSocorrista.socorrer(listaVehiculos.stream().findFirst()));
        }


    }
}
