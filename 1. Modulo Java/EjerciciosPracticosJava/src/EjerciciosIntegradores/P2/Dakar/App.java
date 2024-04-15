package EjerciciosIntegradores.P2.Dakar;

public class App
{
    public static void main( String[] args )
    {
        Carrera dakar = new Carrera(5000, 10000, "Dakar", 3);

        // Definir tipos de vehículos
        TipoVehiculo auto = new TipoVehiculo("Auto", 4, 1000);
        TipoVehiculo moto = new TipoVehiculo("Moto", 2, 300);

        // Crear 3 autos
        Vehiculo auto1 = new Vehiculo(130, 300, 20, "AC222AA", auto);
        Vehiculo auto2 = new Vehiculo(120, 280, 15, "BD333BB", auto);
        Vehiculo auto3 = new Vehiculo(140, 320, 25, "CE444CC", auto);

        // Crear 2 motos
        Vehiculo moto1 = new Vehiculo(180, 250, 10, "MF555MM", moto);
        Vehiculo moto2 = new Vehiculo(170, 270, 12, "NG666NN", moto);

        //Doy de alta 3 autos
        dakar.darDeAltaVehiculo(auto1);
        dakar.darDeAltaVehiculo(auto2);
        dakar.darDeAltaVehiculo(auto3);

        //Elimino por vehiculo y patente
        dakar.eliminarVehiculo(auto2);
        dakar.eliminarVehiculoConPatente("CE444CC");

        //Doy de alta motos
        dakar.darDeAltaVehiculo(moto1);
        dakar.darDeAltaVehiculo(moto2);

        //Soccorro auto y moto
        dakar.socorrer(auto1);
        dakar.socorrer(moto1);

        dakar.ganadorCarrera();
    }
}
