package bootcamp.bendezujonathan.garage;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Garage {

    private Integer id;
    private List<Vehiculo> vehiculos;

    public Garage(Integer id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public List<Vehiculo> orderVehiculos(Comparator<Vehiculo> criteria) {

        if (Objects.isNull(criteria))
            throw new IllegalArgumentException("Criteria should not be null");

        return this.vehiculos
                .stream()
                .sorted(criteria)
                .toList();
    }

    public List<Vehiculo> filterVehiculosByPredicate(Predicate<Vehiculo> filter) {
        return this.vehiculos
        .stream()
        .filter(filter)
        .toList();
    }

    public Double averageCost() {
        return this.vehiculos
                .stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return this.vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

}
