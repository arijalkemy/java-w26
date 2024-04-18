package bootcamp.bendezujonathan.recetas.service.interfaces;

import java.util.List;
import java.util.Optional;

public interface IService<T> {

    Optional<T> searchByName(String name);

    List<T> findAll();

}
