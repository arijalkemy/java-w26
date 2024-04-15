package org.example.carrera;

import org.example.socorrista.SocorristaAuto;
import org.example.socorrista.SocorristaMoto;
import org.example.vehiculo.Auto;
import org.example.vehiculo.Moto;
import org.example.vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Carrera {
    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    /**
     * @param distancia
     * @param premioEnDolares
     * @param nombre
     * @param cantidadVehiculosPermitidos
     */
    public Carrera(int distancia, int premioEnDolares, String nombre, int cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public boolean agregarAuto(Vehiculo... nuevosVehiculos){
        for (Vehiculo vehiculo : nuevosVehiculos) {
            // Verificar si aún hay espacio dentro de la competencia
            if (!this.espacioDisponible()) {
                throw new IllegalStateException("No se permiten más vehículos");
            }

            // Verificar si el vehículo ya está registrado
            if (this.encontrarVehiculo(vehiculo) != null) {
                throw new IllegalArgumentException("El vehículo ya se encuentra registrado");
            }

            // Se carga el vehículo dentro de la lista
            this.vehiculos.add(vehiculo);
            System.out.println("Se agrego el auto");
            System.out.println(vehiculo.toString());
        }
        return true;
    }

    public boolean agregarMoto(Vehiculo... nuevosVehiculos){
        for (Vehiculo vehiculo : nuevosVehiculos) {
            // Verificar si aún hay espacio dentro de la competencia
            if (!this.espacioDisponible()) {
                throw new IllegalStateException("No se permiten más vehículos");
            }

            // Verificar si el vehículo ya está registrado
            if (this.encontrarVehiculo(vehiculo) != null) {
                throw new IllegalArgumentException("El vehículo ya se encuentra registrado");
            }

            // Se carga el vehículo dentro de la lista
            this.vehiculos.add(vehiculo);
            System.out.println("Se agrego la moto");
            System.out.println(vehiculo.toString());
        }
        return true;
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        List<Vehiculo> tempVehiculos = this.vehiculos.stream().filter(veh -> !veh.getPantente().equals(vehiculo.getPantente())).toList();
        this.vehiculos = tempVehiculos;
        System.out.println("Vehiculo eliminado");
        vehiculo.toString();
    }

    public Vehiculo encontrarVehiculo(Vehiculo vehiculo){
        return this.vehiculos.stream().filter(ve -> ve.getPantente().equals(vehiculo.getPantente())).findFirst().orElse(null);
    }

    public Vehiculo encontrarVehiculoPorPatente(UUID patente){
        return this.vehiculos.stream().filter(ve -> ve.getPantente().equals(patente)).findFirst().orElse(null);
    }

    public Vehiculo determinarGanador(){
        Vehiculo ganador = this.vehiculos.get(0);
        double maxValor = Double.MIN_VALUE;

        for (Vehiculo vehiculo : vehiculos) {
            double valor = vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleracion() / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
            if (valor > maxValor) {
                maxValor = valor;
                ganador = vehiculo;
            }
        }

        return ganador;
    }

    public void imprimirVehiculos(){
        System.out.println("Impresion de vehiculos");
        for(Vehiculo vel: this.vehiculos){
            System.out.println(vel.toString());
        }
    }

    public void socorrerAuto(Vehiculo vehiculo){
        Vehiculo vehiculoASocorrer = this.encontrarVehiculo(vehiculo);
        if(vehiculoASocorrer != null && vehiculoASocorrer instanceof Auto){
            this.socorristaAuto.soccorrerAuto((Auto) vehiculoASocorrer);
        }else{
            System.out.println("El socorrista moto no puede socorrer el vehiculo con patente: " + vehiculo.getPantente());
        }
    }

    public void socorrerMoto(Vehiculo vehiculo){
        Vehiculo vehiculoASocorrer = this.encontrarVehiculo(vehiculo);
        if(vehiculoASocorrer != null && vehiculoASocorrer instanceof Moto){
            this.socorristaMoto.socorrerMoto((Moto) vehiculoASocorrer);
        }else{
            System.out.println("El socorrista moto no puede socorrer el vehiculo con patente: " + vehiculo.getPantente());
        }
    }

    public boolean espacioDisponible(){
        return this.vehiculos.size() <= this.cantidadVehiculosPermitidos;
    }
}





























