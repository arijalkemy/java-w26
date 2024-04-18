package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Vehiculo auto = new Vehiculo(200,30,90,"GDB532",TipoVehiculo.AUTO);
        Vehiculo moto = new Vehiculo(400,50,40,"ABC123",TipoVehiculo.MOTO);

        Carrera c = new Carrera(3000,5000,"Carrera de leio",2);
        c.darDeAltaVehiculo(auto);
        c.darDeAltaVehiculo(moto);
        //c.eliminarVehiculoConPatente("GDB53");
        //System.out.println(auto.calcularRendimiento());


        c.socorrerVehiculo(auto);
        c.socorrerVehiculo(moto);

        if (c.verGanador().isPresent()){
            System.out.println("El ganador de " + c.getNombre() +" es:\n" +c.verGanador().get());
        }
        else{
            System.out.println("No hay vehiculos inscriptos en la carrera: " + c.getNombre() + ", no hay ganador. ");
        }

    }
}
