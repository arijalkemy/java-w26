public class Main {
    public static void main(String[] args) {
        SocorristaAuto socorristaAuto = new SocorristaAuto("Socorrista de autos");
        SocorristaMoto socorristaMoto = new SocorristaMoto("Socorrista de motos");

        Carrera carrera = new Carrera(250, 100000,"Gran Turismo",
                4, socorristaAuto, socorristaMoto);

        carrera.darDeAltaAuto(100, 10, 50, "AA688SJ");
        carrera.darDeAltaAuto(110, 9, 40, "AD543FD");
        carrera.darDeAltaAuto(120, 11, 40, "AG543YT");
        carrera.darDeAltaMoto(40, 7, 90, "FRE434");
        carrera.darDeAltaMoto(60, 7, 75, "GFB932"); //supera el limite permitido

        System.out.println("\n" + carrera.obtenerDatosCarrera());

        carrera.eliminarVehiculoConPatente("AA688SJ");

        System.out.println("\n" + carrera.obtenerDatosCarrera() + "\n");

        carrera.socorrer("AD543FD");
        carrera.socorrer("FRE434");

        System.out.println("\nEl vehiculo ganador es: \n" + carrera.definirGanador().toStringPatente());
    }
}