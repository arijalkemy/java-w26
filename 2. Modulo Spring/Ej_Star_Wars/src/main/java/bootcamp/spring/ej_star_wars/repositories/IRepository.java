package bootcamp.spring.ej_star_wars.repositories;

import java.util.Optional;

public interface IRepository<T> {
    Optional<T> findByName(String name);
}