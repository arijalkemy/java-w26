package bootcamp.spring.calculadora_calorias.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import bootcamp.spring.calculadora_calorias.models.Ingrediente;
import bootcamp.spring.calculadora_calorias.models.Plato;

@Repository
public class PlatosRepository implements IPlatoRepository {

    private static final List<Plato> PLATOS = List.of(
        new Plato("Milanesas de carne con papas",
            List.of(new Ingrediente("Milanesas de carne",150),
                    new Ingrediente("Papas",60))),
        new Plato("Fideos con queso",
            List.of(new Ingrediente("Fideos",200),
                    new Ingrediente("Queso",100))),
        new Plato("Sushi",
            List.of(new Ingrediente("Arroz",20),
                    new Ingrediente("Pescado",50)))
    );

    @Override
    public Optional<Plato> findByName(String name) {
        return PLATOS
            .stream()
            .filter(plato -> plato.getNombre().equals(name))
            .findFirst();
    }

}
