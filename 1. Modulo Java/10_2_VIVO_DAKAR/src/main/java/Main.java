public class Main {
    public static void main(String[] args) {

        Carrera carrera = new Carrera(20000,200000,"rally el chaco",4);

        carrera.darDeAltaAuto(300,20,45,"DCY253");
        carrera.darDeAltaAuto(289,34,40,"KSA254");
        carrera.darDeAltaAuto(295,27,44,"BJI094");

        carrera.eliminarVehiculoConPatente("BJI094");


        System.out.println("El auto ganador es: " + carrera.determinarGanador());
        carrera.getListaDeVehiculos().forEach(System.out::println);

    }
}