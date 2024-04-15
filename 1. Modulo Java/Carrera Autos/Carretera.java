import java.util.Comparator;
import java.util.List;

public class Carretera {
    private Integer distancia;
    private Integer premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private Socorrista<Auto> SocorristaAuto;
    private Socorrista<Moto> SocorristaMoto;

    public Carretera(Integer distancia, Integer premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
    }

    public void darDeAltaAuto(Integer velocidad, Integer aceleracion, Integer anguloGiro, String patente) {
        if (this.vehiculos.size() < this.cantidadDeVehiculosPermitidos) {
            this.vehiculos.add(new Auto(velocidad, aceleracion, anguloGiro, patente));
            return;
        }
        System.out.println("plazas llenas");
    }

    public void darDeAltaMoto(Integer velocidad, Integer aceleracion, Integer anguloGiro, String patente) {
        if (this.vehiculos.size() < this.cantidadDeVehiculosPermitidos) {
            this.vehiculos.add(new Moto(velocidad, aceleracion, anguloGiro, patente));
            return;
        }
        System.out.println("plazas llenas");
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        Vehiculo find = this.vehiculos.stream().filter(v -> v.comparePatente(patente)).findFirst().orElseThrow(null);
        if (find != null) {
            vehiculos.remove(find);
        }
    }

    public Vehiculo getGanador(){
        return this.vehiculos.stream().max(Comparator.comparing(Vehiculo::velocidadTotal)).orElseThrow(null);
    }
}
