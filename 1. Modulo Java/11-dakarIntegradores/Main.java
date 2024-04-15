public class Main {
    public static void main(String[] args){
        Carrera carrera = new Carrera(25, 10000, "Rally", 10);


        //hardcodeo ingreso de vehiculos para agilizar el chequeo de funcionamiento
        carrera.darDeAltaAuto(150, 15, 25, "abc123");
        carrera.darDeAltaAuto(250, 10, 20, "fsdg123");
        carrera.darDeAltaAuto(70, 70, 50, "grth123");
        carrera.darDeAltaAuto(160, 17, 24, "fdfgh123");
        carrera.darDeAltaAuto(190, 16, 26, "bnh123");
        carrera.darDeAltaMoto(100, 40, 80, "ytre654");
        carrera.darDeAltaMoto(160, 30, 80, "ymjhgfde654");
        carrera.darDeAltaMoto(200, 90, 80, "hfde654");
        carrera.darDeAltaMoto(200, 40, 80, "yhfdsase654");
        carrera.darDeAltaMoto(300, 10, 40, "ygsrrfe654");
        //agrego uno mas para ver si funciona el limite de capacidad de Carrera
        carrera.darDeAltaMoto(400, 440, 840, "arafue123");


        //eliminacion de vehiculos
        //carrera.eliminarVehiciloConPatente("ymjhgfde654");
        Auto autoAEliminar = new Auto(150, 15, 25, "abc123");
        carrera.eliminarVehiculo(autoAEliminar);
        carrera.darDeAltaMoto(300, 10, 40, "ygsrrfe654");

        //se determina el ganador
        carrera.determinarGanador();

        //socorrer
        carrera.socorrerMoto("ygsrrfe654");





    }
}
