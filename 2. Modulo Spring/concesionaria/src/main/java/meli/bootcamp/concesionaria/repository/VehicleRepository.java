package meli.bootcamp.concesionaria.repository;

import lombok.NoArgsConstructor;
import meli.bootcamp.concesionaria.entity.Vehicle;
import meli.bootcamp.concesionaria.repository.interfaces.ICrud;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
@NoArgsConstructor
public class VehicleRepository implements ICrud<Vehicle> {

    private final List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public void save(List<Vehicle> vehicles) {
        vehicles.forEach(
                (v) -> {
                    v.setId(CollectionUtils.isEmpty(this.vehicles) ? 1 : this.vehicles.size() + 1);
                    this.vehicles.add(v);
                }
        );
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }

    @Override
    public Vehicle findById(Integer id) {
        return vehicles.stream().filter(v -> Objects.equals(v.getId(), id)).findFirst().orElse(null);
    }
}
