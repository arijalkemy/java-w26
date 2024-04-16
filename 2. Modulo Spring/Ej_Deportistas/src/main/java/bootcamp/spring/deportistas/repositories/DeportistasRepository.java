package bootcamp.spring.deportistas.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import bootcamp.spring.deportistas.models.Deportista;

@Repository
public class DeportistasRepository implements IRepository<Deportista>{

    private static final List<Deportista> DEPORTISTAS = List.of(
        new Deportista("Juan","Perez",25),
        new Deportista("Pedro","Gonzalez",27),
        new Deportista("Marcos","Puma",51)
    );

    @Override
    public List<Deportista> getAll() {
        return DEPORTISTAS;
    }
}