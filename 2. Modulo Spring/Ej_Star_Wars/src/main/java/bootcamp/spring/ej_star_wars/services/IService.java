package bootcamp.spring.ej_star_wars.services;

import java.util.Optional;

public interface IService<T> {
    Optional<T> getByName(String name);
}
