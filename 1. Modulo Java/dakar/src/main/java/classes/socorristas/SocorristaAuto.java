package classes.socorristas;

import classes.vehiculos.Auto;

public class SocorristaAuto extends Socorrista<Auto> {
    public void socorrer(Auto auto) {
        System.out.println("Socorriendo auto " + auto);
    }
}
