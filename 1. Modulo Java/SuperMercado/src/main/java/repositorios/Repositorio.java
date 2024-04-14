package repositorios;

import java.util.List;
import java.util.Optional;

public interface Repositorio <T>{

    public Optional<T> buscarPorId(String id);

    public void guardar(T elemento);

    public void eliminar(T elemento);

    public List<T> obtenerTodos();

}
