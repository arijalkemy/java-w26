import java.util.Comparator;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;

    private SocorristaMotos socorristaMotos;
    private SocorristaAuto socorristaAuto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> listaVehiculos, SocorristaMotos socorristaMotos, SocorristaAuto socorristaAuto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaVehiculos = listaVehiculos;
        this.socorristaMotos = socorristaMotos;
        this.socorristaAuto = socorristaAuto;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
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

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", listaVehiculos=" + listaVehiculos +
                '}';
    }

    public void darDeAltaAuto(Autos auto) {
        if(listaVehiculos.size() < cantidadDeVehiculosPermitidos){
            listaVehiculos.add(auto);
        } else{
            System.out.println("La lista de vehiculos permitidos está completa.");
        }
    }
    public void darDeAltaMoto(Motos moto){
        if(listaVehiculos.size() <= cantidadDeVehiculosPermitidos){
            listaVehiculos.add(moto);
        } else {
            System.out.println("La lista de vehiculos permitidos está completa.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        listaVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        for(Vehiculo v : listaVehiculos){
            if (v.getPatente().equals(unaPatente)){
                listaVehiculos.remove(v);
                break;
            }
        }
    }
    public void ganador(){
        Vehiculo vehiculoConMayorPuntaje = listaVehiculos.stream()
                .max(Comparator.comparingDouble(Vehiculo::calcularPuntaje))
                .orElse(null);
        if (vehiculoConMayorPuntaje != null){
            System.out.println("El vehiculo GANADOR es el patente: " + vehiculoConMayorPuntaje.getPatente()
                                + " con una velocidad máxima de " + vehiculoConMayorPuntaje.getVelocidad());
        }
        else{
            System.out.println("No hay vehiculos en la lista");
        }
    }
    public void socorrerMoto(Motos unaMoto){
        System.out.println("Socorriendo moto... Patente: " + unaMoto.getPatente());
    }
    public void socorrerAuto(Autos unAuto){
        System.out.println("Socorriendo auto... Patente: " + unAuto.getPatente());
    }

}
