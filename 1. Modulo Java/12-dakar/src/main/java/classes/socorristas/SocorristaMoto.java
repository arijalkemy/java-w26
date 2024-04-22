package classes.socorristas;

import classes.vehiculos.Moto;

public class SocorristaMoto extends Socorrista<Moto> {
    public void socorrer(Moto moto) {
        System.out.println("Socorriendo moto " + moto);
    }
}
