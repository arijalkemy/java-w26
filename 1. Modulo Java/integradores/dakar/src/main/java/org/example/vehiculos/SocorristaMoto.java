package org.example.vehiculos;

public class SocorristaMoto implements ISocorrista<Moto> {
    @Override
    public void socorrer(Moto moto) {
        System.out.println("Socorrista moto: " + this.getPatente(moto));
    }

    public SocorristaMoto() {}
}
