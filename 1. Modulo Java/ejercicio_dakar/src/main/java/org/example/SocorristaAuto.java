package org.example;

public class SocorristaAuto {

    public SocorristaAuto(){

    }

    public void socorrer(Auto auto){
        System.out.println("Socorriendo auto\n" +
                "Patente: " + auto.getPatente() + "\n");
    }

}
