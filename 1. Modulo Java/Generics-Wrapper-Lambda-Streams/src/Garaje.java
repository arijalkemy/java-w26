import java.util.Comparator;
import java.util.List;

public class Garaje {
    private Integer id;
    private List<Vehiculo> vehiculos;

    public void ordenarVehiculos(){
        vehiculos.stream()
                .sorted(Comparator.comparingInt(Vehiculo::getCosto))
                .forEach(System.out::println);
    }
    public void ordenarPorMarcaYprecio(){
        vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getModelo).thenComparingInt(Vehiculo::getCosto))
                .forEach(System.out::println);
    }

    public void cochesMenoresAMil(){
        vehiculos.stream()
                .filter(Vehiculo::esMenorQueMil)
                .forEach(System.out::println);
    }

    public void cochesMayoresAMil(){
        vehiculos.stream()
                .filter(Vehiculo::esMayorQueMil)
                .forEach(System.out::println);
    }

    public void promedioDePrecio(){
       double precioPromedio = vehiculos.stream()
                .mapToInt(Vehiculo::getCosto)
               .average()
               .orElse(0.0);
        System.out.println(precioPromedio);

    }

    public Garaje(Integer id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Garaje{" +
                "id=" + id +
                ", vehiculos=" + vehiculos +
                '}';
    }

}
