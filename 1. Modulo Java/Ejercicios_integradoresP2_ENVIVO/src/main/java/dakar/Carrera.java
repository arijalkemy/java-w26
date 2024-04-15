package dakar;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Carrera {
    double distancia = 0;
    double premioEnDolares =0;
    String nombre;
    int cantidadDeVehiculosPermitidos;
    List<Vehiculo> listaDeVehiculos;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
    }
    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if(listaDeVehiculos.size()<cantidadDeVehiculosPermitidos) {
            listaDeVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        }else{
            System.out.println("No se pueden agregar más vehiculos a esta carrera");
        }
    }
    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if(listaDeVehiculos.size()<cantidadDeVehiculosPermitidos) {
            listaDeVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        }else{
            System.out.println("No se pueden agregar más vehiculos a esta carrera");
        }
    }
    public void eliminarVehiculo(Vehiculo vehiculo) {
        if(listaDeVehiculos.contains(vehiculo)){
            listaDeVehiculos.remove(vehiculo);
            System.out.println("Vehiculo eliminado");
        }else{
            System.out.println("Vehículo no se encuentra en la lista");
        }
    }
    public void eliminarVehiculoPatente(String laPatente) {
        boolean eliminado = listaDeVehiculos.removeIf(v->v.patente.equals(laPatente));
        if(eliminado){
            System.out.println("Vehiculo con patente: "+laPatente+" eliminado");
        }else{
            System.out.println("Vehiculo no se encuentra en la lista");
        }
    }
    public Vehiculo definirGanador(){
        return listaDeVehiculos.stream().max(Comparator.comparingDouble(v->calcularDesempeno(v))).orElse(null);
    }
    public double calcularDesempeno(Vehiculo v){
        return v.velocidad * 0.5 * v.aceleracion / (v.anguloDeGiro*(v.peso-v.ruedas*100));
    }
    public void socorrerAuto(String patente){
        listaDeVehiculos.stream().filter(v->v instanceof Auto && v.patente.equals(patente)).findFirst().ifPresent(auto->new SocorristaAuto().socorrer((Auto) auto));
    }
    public void socorrerMoto(String patente){
        listaDeVehiculos.stream().filter(v->v instanceof Moto && v.patente.equals(patente)).findFirst().ifPresent(moto -> new SocorristaMoto().socorrer((Moto) moto));
    }
}
