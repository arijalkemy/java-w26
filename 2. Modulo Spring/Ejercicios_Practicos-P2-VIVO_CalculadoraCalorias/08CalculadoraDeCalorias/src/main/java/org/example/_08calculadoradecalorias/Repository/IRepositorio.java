package org.example._08calculadoradecalorias.Repository;

import org.example._08calculadoradecalorias.Model.Plato;

public interface IRepositorio {
    public Plato findPlato(String nombre);
}
