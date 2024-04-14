import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Garaje implements ICalculable<Vehiculo>{
    private int id;
    private List<Vehiculo> vehiculos;

    public Garaje(int id) {
        this.id = id;
        this.vehiculos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void agregarVehiculo(Vehiculo... vehiculos) {
        for (Vehiculo v : vehiculos) {
            this.vehiculos.add(v);
        }
    }

    public List<Vehiculo> ordenarVehiculos() {
        return this.getVehiculos().stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto)).toList();
        //      .sorted((v1,v2) -> Double.compare(v1.getCosto(), v2.getCosto())).toList();
    }

    public List<Vehiculo> ordenarPorMarcaYPrecio() {
        return this.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca)
                .thenComparingDouble(Vehiculo::getCosto)).toList();
    }

    public List<Vehiculo> obtenerAutosConPrecioNoMayorAMil() {
        return this.getVehiculos().stream().filter(v->v.getCosto()<1000).toList();
    }
    public List<Vehiculo> obtenerAutosConPrecioMayorOIgualAMil() {
        return this.getVehiculos().stream().filter(v->v.getCosto()>=1000).toList();
    }

    public double calcularPromedio(List<Vehiculo> vehiculos){
        return vehiculos.stream().mapToDouble(v-> v.getCosto()).average().orElse(0.0);
    }

}
