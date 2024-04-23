import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Garaje {
    //atributos
    private int id;
    private List<Vehiculo> vehiculos;

    //Constructor
    public Garaje(int id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    //metodo que ordena por precio
    public void ordenaPrecio(){
        vehiculos.stream().sorted((v1,v2)-> Double.compare(v1.getCosto(), v2.getCosto())).forEach(System.out::println);
    }
    //metodo que ordena por marca y precio
    public void ordenaMarcaPrecio(){
        vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);
    }

    //metodo que hace la seleccion de vehiculo
    public void seleccionVehiculos(){
        vehiculos.stream().filter(v -> v.getCosto()<1000).forEach(System.out::println);
        vehiculos.stream().filter(v -> v.getCosto()>=1000).forEach(System.out::println);
        double avg = vehiculos.stream().mapToDouble(v -> v.getCosto()).average().getAsDouble();
        System.out.println(avg);
    }
    //setters y Getters
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
}
