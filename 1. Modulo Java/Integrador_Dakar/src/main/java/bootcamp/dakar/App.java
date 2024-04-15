package bootcamp.dakar;

import java.util.List;

import bootcamp.dakar.carrera.Carrera;
import bootcamp.dakar.vehiculos.corredores.NombreVehiculo;
import bootcamp.dakar.vehiculos.corredores.TipoVehiculo;
import bootcamp.dakar.vehiculos.corredores.Vehiculo;
import bootcamp.dakar.vehiculos.socorristas.SocorristaAuto;
import bootcamp.dakar.vehiculos.socorristas.SocorristaMoto;

public class App {
    public static void main(String[] args) {
        Carrera dakarCordoba = new Carrera(22, "Sierras de Cordoba");
        setUpVehiculos().forEach(dakarCordoba::agregarVehiculo);
        dakarCordoba.agregarSocorristaAutoAll(setUpSocorristaAutos());
        dakarCordoba.agregarSocorristaMotoAll(setUpSocorristaMotos());
        dakarCordoba.anunciarInicio();
        dakarCordoba.simAccidente();

        dakarCordoba.ganador().ifPresentOrElse(ganador -> System.out.printf(">> El ganador es el vehiculo con patente %s con un resultado de: %.2f%n", ganador.getPatente(), ganador.result()),
         () -> System.out.println("PARECE QUE NO TENEMOS GANADOR"));
    }

    private static List<Vehiculo> setUpVehiculos() {
        TipoVehiculo autoTipo = new TipoVehiculo(NombreVehiculo.AUTO, 1000, 4);
        TipoVehiculo motoTipo = new TipoVehiculo(NombreVehiculo.MOTO, 600, 2);

        Vehiculo auto1 = new Vehiculo(100, 20, 20, "AA 210 FC", autoTipo);
        Vehiculo auto2 = new Vehiculo(110, 19, 20, "AA 211 FC", autoTipo);

        Vehiculo moto1 = new Vehiculo(80, 13, 20, "AA 212 FC", motoTipo);
        Vehiculo moto2 = new Vehiculo(87, 11, 20, "AA 213 FC", motoTipo);
        Vehiculo moto3 = new Vehiculo(88, 12, 20, "AA 214 FC", motoTipo);

        return List.of(auto1, auto2, moto1, moto2, moto3);
    }

    private static SocorristaAuto[] setUpSocorristaAutos() {
        return new SocorristaAuto[] {
                new SocorristaAuto(1),
                new SocorristaAuto(2)
        };
    }

    private static SocorristaMoto[] setUpSocorristaMotos() {
        return new SocorristaMoto[] {
                new SocorristaMoto(1),
                new SocorristaMoto(2)
        };
    }
}
