package com.calculadora.calorias.service;

import com.calculadora.calorias.dto.IngredienteDTO;
import com.calculadora.calorias.dto.PlatilloCompletoDTO;
import com.calculadora.calorias.dto.PlatilloDTO;
import com.calculadora.calorias.entity.Ingrediente;
import com.calculadora.calorias.entity.Platillo;

import java.util.ArrayList;
import java.util.List;

public interface IPlatilloService {
    PlatilloCompletoDTO getPlatillo(PlatilloDTO platilloDTO);


    List<IngredienteDTO> getIngredientes();
    List<PlatilloCompletoDTO> getPlatillos();
    List<PlatilloCompletoDTO> getPlatillosFilter(List<PlatilloDTO> platillos);
}
