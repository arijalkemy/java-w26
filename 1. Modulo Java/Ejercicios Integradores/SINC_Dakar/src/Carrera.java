import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera {
    private double distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos,
                   SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaVehiculos = new ArrayList<>();
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(int premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        //valido si hay lugar disponible para agregar un auto
        if (listaVehiculos.stream().count() < cantidadDeVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            listaVehiculos.add(auto);
        }
    };

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        //valido si hay lugar disponible para agregar una moto
        if (listaVehiculos.stream().count() < cantidadDeVehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            listaVehiculos.add(moto);
        }
    }
        ;

    public void eliminarVehiculo (Vehiculo vehiculo){
        if (listaVehiculos.contains(vehiculo)) {
                listaVehiculos.remove(vehiculo);
        }
    };

    public void eliminarVehiculoConPatente (String unaPatente){
        Vehiculo vehiculo = listaVehiculos.stream()
                .filter(x -> x.getPatente().equals(unaPatente))
                .findFirst()
                .orElse(null);
        if (vehiculo != null) {
            listaVehiculos.remove(vehiculo);
        }
    }

    public Vehiculo definirGanador () {
        Vehiculo vehiculoGanador = listaVehiculos.get(0);
        double maxValorPerformance = 0;

        for (Vehiculo v : listaVehiculos) {
            double valorPerformance = v.getVelocidad() * 0.5 * v.getAceleracion() /
                    (v.getAnguloDeGiro() * (v.getPeso() - v.getCantidadRuedas() * 100));
            if (valorPerformance > maxValorPerformance) {
                maxValorPerformance = valorPerformance;
                vehiculoGanador = v;
            }
        }
        return vehiculoGanador;
    }

    public String obtenerDatosCarrera(){
        return "Nombre: " + nombre + "\n" +
                "Distancia: " + distancia + "\n" +
                "Premio en dolares: " + premioEnDolares + "\n" +
                "Cantidad de vehiculos permitidos: " + cantidadDeVehiculosPermitidos + "\n" +
                "Vehiculos inscriptos: " + listaVehiculos.stream()
                                                            .map(v -> v.getPatente())
                                                            .collect(Collectors.joining(", "));
    }

    public void socorrer(String patente) {
        Vehiculo vehiculo = listaVehiculos.stream()
                .filter(x -> x.getPatente().toUpperCase().equals(patente.toUpperCase()))
                .findFirst()
                .orElse(null);
        if (vehiculo instanceof Auto) {
            socorristaAuto.socorrer(vehiculo);
        }
        if (vehiculo instanceof Moto) {
            socorristaMoto.socorrer(vehiculo);
        }
    }
}

