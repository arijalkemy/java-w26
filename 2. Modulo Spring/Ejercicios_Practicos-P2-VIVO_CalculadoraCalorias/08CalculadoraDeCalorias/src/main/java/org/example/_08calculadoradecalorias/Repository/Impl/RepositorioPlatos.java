package org.example._08calculadoradecalorias.Repository.Impl;

import org.example._08calculadoradecalorias.Model.Ingrediente;
import org.example._08calculadoradecalorias.Model.Plato;
import org.example._08calculadoradecalorias.Repository.IRepositorio;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class RepositorioPlatos implements IRepositorio {

    private List<Plato> platos;

    public RepositorioPlatos() {
        this.platos = new ArrayList<>();
        List<Ingrediente> ingredientesPizza = List.of(new Ingrediente("Harina", 200), new Ingrediente("Salsa", 150));
        this.platos.add(new Plato("Pizza", 100, ingredientesPizza));
    }

    @Override
    public Plato findPlato(String nombre) {
        return this.platos.stream().filter(p -> p.getNombre().equals(nombre)).findFirst().orElse(null);
    }
}
