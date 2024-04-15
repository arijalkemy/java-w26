package org.example;

public class App 
{
    public static void main( String[] args )
    {
        // Crear una carrera
        Carrera carrera = new Carrera(1000, 5000, "Carrera de autos", 4);

        // Dar de alta vehículos (autos y motos)
        carrera.darDeAltaAuto(150, 10, 5.5, "ABC123");
        carrera.darDeAltaMoto(120, 15, 4.0, "XYZ456");
        carrera.darDeAltaAuto(342, 321, 34.2, "AD453PG");
        carrera.darDeAltaMoto(134, 343, 22, "APG432KG");
        // Eliminar un vehículo por patente
        carrera.eliminarVehiculoConPatente("XYZ456");

        // Mostrar información de los vehículos en la carrera
        System.out.println("Vehículos en la carrera:");
        for (Vehiculo vehiculo : carrera.getListaVehiculos()) {
            System.out.println(vehiculo.toString());
        }

        // Determinar el ganador de la carrera
        carrera.ganadorCarrera();

        // Socorrer un vehículo
        Socorrista soco = new Socorrista();
        Vehiculo vehiculoSocorrer = new Vehiculo(100, 8, 4.5, "DEF789", new TipoVehiculo("auto", 4, 1200));
        carrera.socorrer(vehiculoSocorrer);
    }
}
