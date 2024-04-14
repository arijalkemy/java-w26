import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Se instancian vehiculos para la carrera
        Autos fordSierra = new Autos(140,30,20,"ABC123");
        Autos nissanSkyline = new Autos(190,45,20,"ASD123");
        Autos chevroletCorsa = new Autos(150,30,20,"COR123");
        Motos ns = new Motos(145,59,60,"NS200");
        Motos tornado = new Motos(140, 60,60,"TOR250");
        List<Vehiculo> listadoCarrera = new ArrayList<>();

        //Se instancian dos socorristas
        SocorristaMotos socorristaMoto = new SocorristaMotos(100,30,2,"SOCM1",800,4);
        SocorristaAuto socorristaAuto = new SocorristaAuto(100,32,2,"SOCAU",900,4);

        //Se instancia la nueva carrera
        Carrera race = new Carrera(120,50000,"Termas de Rio Hondo",5,listadoCarrera, socorristaMoto, socorristaAuto);

        //Se dan de alta 5 competidores
        race.darDeAltaAuto(fordSierra);
        race.darDeAltaAuto(nissanSkyline);
        race.darDeAltaAuto(chevroletCorsa);
        race.darDeAltaMoto(ns);
        race.darDeAltaMoto(tornado);

        //Se elimina participante manualmente
        race.eliminarVehiculo(fordSierra);

        //Se elimina participante por numero de patente.
        race.eliminarVehiculoConPatente("COR123");
        for(Vehiculo x : listadoCarrera){
            System.out.println(x);
        }

        //Se socorre una moto y un auto en la carrera
        race.socorrerMoto(tornado);
        race.socorrerAuto(chevroletCorsa);

        race.ganador();

    }
}