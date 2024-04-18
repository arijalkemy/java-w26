package bootcamp.bendezujonathan.recetas.repository.interfaces;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {
	
    List<T> findAll();
    Optional<T> find(String name);
    void add(T model);

}
