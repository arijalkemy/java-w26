package com.meli.ejercicioenvivodto.Service;

import com.meli.ejercicioenvivodto.Repository.DTO.DeporteDTO;
import com.meli.ejercicioenvivodto.Repository.DTO.PersonaDTO;
import java.util.List;

public interface IDeportesService {

    public List<DeporteDTO> listaDeportes();
    public String nombreDeporte(String nombre);
    public List<PersonaDTO> listaPersonas();

}
