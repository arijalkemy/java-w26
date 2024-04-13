package org.example.vehiculos;

public class SocorristaAuto implements ISocorrista<Auto>{

    @Override
    public void socorrer(Auto auto) {
        System.out.println("Socorrista auto: " + this.getPatente(auto));
    }

    public SocorristaAuto() {}
}
