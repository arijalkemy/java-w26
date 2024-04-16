package Supermercado.CRUD;

import java.util.List;
import java.util.Optional;

public interface CRUD <T>{
    // se requiere la creación de una interfaz “CRUD” que sea capaz de contener,
    // mediante genéricos, todos los métodos necesarios para realizar altas, bajas, modificaciones y consultas.

  public void guardar(T t);
  public void mostrar();
  public Optional<T> buscar(String id);
    public void eliminar(String id);
    public List<T> traerTodos();


}
