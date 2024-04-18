package bootcamp.spring.calculadora_calorias.repositories;

import java.util.Optional;

public interface IRepository<T> {
    Optional<T> findByName(String name);
}
