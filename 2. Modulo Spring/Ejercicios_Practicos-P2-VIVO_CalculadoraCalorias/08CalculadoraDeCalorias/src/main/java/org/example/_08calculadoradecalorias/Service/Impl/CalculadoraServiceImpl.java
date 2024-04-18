package org.example._08calculadoradecalorias.Service.Impl;

import org.example._08calculadoradecalorias.DTO.CaloriasPlatoDTO;
import org.example._08calculadoradecalorias.DTO.IngredienteDTO;
import org.example._08calculadoradecalorias.Model.Ingrediente;
import org.example._08calculadoradecalorias.Model.Plato;
import org.example._08calculadoradecalorias.Repository.IRepositorio;
import org.example._08calculadoradecalorias.Service.ICalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CalculadoraServiceImpl implements ICalculadoraService {

    @Autowired
    IRepositorio repositorioPlatos;

    @Override
    public CaloriasPlatoDTO calcularCaloriasDe(String nombrePlato, int peso) {
        Plato plato = repositorioPlatos.findPlato(nombrePlato);
        if (plato == null) {
            return null;
        }
        int sumaCalorias = 0;
        for (Ingrediente ingrediente : plato.getIngredientes()) {
            sumaCalorias += ingrediente.getCalorias();
        }
        return new CaloriasPlatoDTO(sumaCalorias * (peso / plato.getPeso()));
    }

    @Override
    public List<IngredienteDTO> obtenerIngredientesDe(String nombrePlato) {
        Plato plato = repositorioPlatos.findPlato(nombrePlato);
        List<IngredienteDTO> ingredientesDTO = new ArrayList<>();
        plato.getIngredientes().forEach(i -> ingredientesDTO.add(new IngredienteDTO(i.getNombre(), i.getCalorias())));
        return ingredientesDTO;
    }

    @Override
    public IngredienteDTO obtenerIngredienteConMasCaloriasDe(String nombrePlato) {
        Plato plato = repositorioPlatos.findPlato(nombrePlato);
        Ingrediente maximo = null;
        for (Ingrediente ingrediente : plato.getIngredientes()) {
            if (maximo == null || ingrediente.getCalorias() > maximo.getCalorias()) {
                maximo = ingrediente;
            }
        }
        if (maximo == null) {
            return null;
        }
        return new IngredienteDTO(maximo.getNombre(), maximo.getCalorias());
    }


}
