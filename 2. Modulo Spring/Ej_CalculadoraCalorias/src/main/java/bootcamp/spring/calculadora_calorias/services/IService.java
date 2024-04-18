package bootcamp.spring.calculadora_calorias.services;

import java.util.Optional;

public interface IService<T> {
    Optional<T> searchByName(String name);
}
