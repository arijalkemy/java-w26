package org.ejercicio.calculadoradecalorias.repository;

import org.ejercicio.calculadoradecalorias.entity.Ingrediente;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class IngredientesRepository implements IIngredientesRepository{

    MockDB mockDB = new MockDB();

    @Override
    public List<Ingrediente> buscarTodos() {
        return mockDB.getIngredientes();
    }

    @Override
    public Ingrediente buscarPorNombre(String nombre) {
        Optional<Ingrediente> ingredienteReturn = mockDB.getIngredientes().stream().filter(
                ingrediente ->
                    ingrediente.getName().equals(nombre)
        ).findFirst();
        return ingredienteReturn.orElse(null);
    }
}
