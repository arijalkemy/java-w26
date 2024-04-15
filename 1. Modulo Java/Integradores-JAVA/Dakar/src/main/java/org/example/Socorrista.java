package org.example;

public class Socorrista {

    public Socorrista(){}
    public void socorrerVehiculo(String patente, String tipo){
        if(tipo.equals("auto")){
            System.out.println("Socorriendo auto con patente: "+patente);
        }
        else if(tipo.equals("moto")){
            System.out.println("Socorriendo moto con patente: "+patente);
        }

    }
}
