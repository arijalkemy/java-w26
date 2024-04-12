package org.example.clases;

import org.example.interfaces.ISocorrer;

public class SocorristaAuto implements ISocorrer<Auto> {
    public void socorrer(Auto auto){
        System.out.println("Socorriendo auto de patente " + auto.getPatente());
    }
}
