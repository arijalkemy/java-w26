import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera{
    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private static int contadorVehiculos = 0;
    private static List<Vehiculo> listaVehiculos = new ArrayList<>();
    private static SocorristaAuto socorristaAuto = new SocorristaAuto();
    private static SocorristaMoto socorristaMoto = new SocorristaMoto();

    public Carrera(int distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public void darDeAltaAuto(int velocidad, int aceleracion, int anguloGiro, String patente){
        /**
         * Inscripcion de autos
         */
        if (contadorVehiculos < cantidadDeVehiculosPermitidos){
            Vehiculo auto = new Auto(velocidad, aceleracion, anguloGiro, patente);
            listaVehiculos.add(auto);
            ++contadorVehiculos;
            System.out.println("Auto anotado, patente: " + patente);
        }else{
            System.out.println("Inscripcion Fallida, no hay cupos.");
        }


    }

    public void darDeAltaMoto(int velocidad, int aceleracion, int anguloGiro, String patente){
        /**
         * Inscripcion de motos
         */
        if (contadorVehiculos < cantidadDeVehiculosPermitidos){
            Vehiculo moto = new Moto(velocidad, aceleracion, anguloGiro, patente);
            listaVehiculos.add(moto);
            ++contadorVehiculos;
            System.out.println("Moto anotada, patente: " + patente);

        }else{
            System.out.println("Inscripcion Fallida, no hay cupos.");
        }
    }


    public void eliminarVehiculo(Vehiculo vehiculo){
        /**
         * elimina al vehiculo designado
         */
        this.listaVehiculos.remove(vehiculo);
        System.out.println("Se elimino al vehiculo: " + vehiculo.getPatente());
        --contadorVehiculos;
    }

    public void eliminarVehiciloConPatente(String patente){
        /**
         * busca al vehiculo por patente y procede a eliminarlo
         */
        for (Vehiculo vehiculo : listaVehiculos){
            if (vehiculo.getPatente().equals(patente)){
                //busco el numero de indice y lo elimino al vehiculo correspondiente
                listaVehiculos.remove(listaVehiculos.indexOf(vehiculo));
                System.out.println("Se elimino al vehiculo: " + vehiculo.getPatente());
                --contadorVehiculos;
                break;
            }
        }
    }



    public void determinarGanador() {

        Vehiculo ganador = listaVehiculos.stream()
                .max(Comparator.comparingDouble(Vehiculo::getIndiceGanador))
                .orElse(null);
        System.out.println("El ganador de la carrera es vehiculo con patente: " + ganador.getPatente());
    }

    //socorrista de motos
    public void socorrerMoto(String patente){
        Vehiculo vehiculoASocorrer = listaVehiculos.stream()
                .filter( vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst()
                .get();
        socorristaMoto.socorrer((Moto) vehiculoASocorrer);

    }

    //socorrista de autos
    public void socorrerAuto(String patente){
        Vehiculo vehiculoASocorrer = listaVehiculos.stream()
                .filter( vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst()
                .get();
        socorristaAuto.socorrer((Auto) vehiculoASocorrer);
    }


}
