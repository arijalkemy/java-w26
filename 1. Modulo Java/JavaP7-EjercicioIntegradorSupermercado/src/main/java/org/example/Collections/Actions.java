package org.example.Collections;

public interface Actions<T>{
    public void guardar(T objeto);
    public void mostrar();
    public T buscar(String dni);
    public void eliminar(String dni);

}
