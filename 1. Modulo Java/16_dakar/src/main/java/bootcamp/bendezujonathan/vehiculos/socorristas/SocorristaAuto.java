package bootcamp.bendezujonathan.vehiculos.socorristas;

import bootcamp.bendezujonathan.vehiculos.corredores.NombreVehiculo;
import bootcamp.bendezujonathan.vehiculos.corredores.Vehiculo;

public class SocorristaAuto implements Socorrista {

    private int id;

    public SocorristaAuto(int id) {
        this.id = id;
    }

    @Override
    public void socorrer(Vehiculo aSocorrer) {
        if (!aSocorrer.isType(NombreVehiculo.AUTO))
            System.err.println("Oh!! No era un auto :(");
        System.out.println("Socorriendo un auto! ID [" + id + "]");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
