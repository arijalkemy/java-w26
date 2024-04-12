package org.example.Repository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T> {

    public void alta(T objeto);

    public void mostrarPantalla();

    public Optional<T> buscar(Integer id);
    public void baja (Long id);

}
