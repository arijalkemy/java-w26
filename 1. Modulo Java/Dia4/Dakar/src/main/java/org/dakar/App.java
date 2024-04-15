package org.dakar;

/**
 * Esta resolucón se podría mejorar ya que no es necesario que Auto y Moto sean clases que
 * heredan de Vehiculo, ya que solo difieren entre ellas por los valores de sus parámetros,
 * no en su comportamiento. Se resolvió de esta manera debido a que el ejercicio así lo pedía.
 */
public class App {
    public static void main(String[] args) {
        // Crear una instancia de la carrera
        Carrera carrera = new Carrera(1000, 10000, "Gran Premio", 5);

        // Agregar vehículos a la carrera
        carrera.darDeAltaAuto(200, 10, 20, "ABC123");
        carrera.darDeAltaAuto(180, 12, 25, "DEF456");
        carrera.darDeAltaMoto(150, 15, 30, "GHI789");
        carrera.darDeAltaMoto(170, 14, 28, "JKL012");


        // Mostrar información de los vehículos en la carrera
        System.out.println("Vehículos en la carrera:");
        for (Vehiculo vehiculo : carrera.getListaVehiculos()) {
            System.out.println("Patente: " + vehiculo.getPatente() + ", Velocidad: " + vehiculo.getVelocidad() +
                    ", Aceleración: " + vehiculo.getAceleracion() + ", Ángulo de Giro: " + vehiculo.getAnguloDeGiro());
        }

        // Definir al ganador de la carrera
        Vehiculo ganador = carrera.definirGanador();
        System.out.println("El ganador de la carrera es el vehículo con patente: " + ganador.getPatente());

        // Socorrer un auto y una moto
        carrera.socorrerAuto("ABC123");
        carrera.socorrerMoto("GHI789");
    }
}

