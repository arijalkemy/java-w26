package org.example;

public class SocorristaMoto {

    public SocorristaMoto(){

    }

    public void socorrer(Moto moto){
        System.out.println("Socorriendo moto\n" +
                "Patente: " + moto.getPatente() + "\n");
    }
}
