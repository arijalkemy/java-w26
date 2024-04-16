package bootcamp.spring.deportistas.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import bootcamp.spring.deportistas.enums.NivelEnum;
import bootcamp.spring.deportistas.models.Deporte;

@Repository
public class DeportesRepository implements IRepository<Deporte> {

    private Random rnd = new Random();

    private static final List<Deporte> DEPORTES = List.of(
            new Deporte("FUTBOL", NivelEnum.BASICO.name()),
            new Deporte("BASQUET", NivelEnum.AVANZADO.name()),
            new Deporte("HOCKEY", NivelEnum.MEDIANO.name()));

    @Override
    public List<Deporte> getAll() {
        return DEPORTES;
    }

    public Deporte getRandomSport() {
        return DEPORTES.get(rnd.nextInt(0, DEPORTES.size() - 1));
    }

    public Optional<Deporte> find(String nombreDeporte) {
        
        return DEPORTES
            .stream()
            .filter(deporte -> deporte.getNombre().equals(nombreDeporte))
            .findFirst();
    }

}
