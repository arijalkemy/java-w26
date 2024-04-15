package bootcamp.dakar.vehiculos.socorristas;

import bootcamp.dakar.vehiculos.corredores.NombreVehiculo;
import bootcamp.dakar.vehiculos.corredores.Vehiculo;

public class SocorristaMoto implements Socorrista {

    private int id;

    public SocorristaMoto(int id) {
        this.id = id;
    }

    @Override
    public void socorrer(Vehiculo aSocorrer) {
        if (!aSocorrer.isType(NombreVehiculo.MOTO))
            System.err.println("Oh!! No era una Moto :(");
        System.out.println("Socorriendo una moto! ID [" + id + "]");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
