package com.spring.calculadoracalorias.service;

import com.spring.calculadoracalorias.entity.Ingrediente;
import com.spring.calculadoracalorias.service.interfaces.IIngredientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteService  implements IIngredientesService {


    @Override
    public List<Ingrediente> getAllIngredientes() {
        return null;
    }
}
