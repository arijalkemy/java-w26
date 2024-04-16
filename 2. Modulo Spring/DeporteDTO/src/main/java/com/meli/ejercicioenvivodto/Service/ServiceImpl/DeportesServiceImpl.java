package com.meli.ejercicioenvivodto.Service.ServiceImpl;

import com.meli.ejercicioenvivodto.Modelo.PersonasList;
import com.meli.ejercicioenvivodto.Repository.DTO.DeporteDTO;
import com.meli.ejercicioenvivodto.Repository.DTO.PersonaDTO;
import com.meli.ejercicioenvivodto.Service.IDeportesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeportesServiceImpl implements IDeportesService {

    @Override
    public List<PersonaDTO> listaPersonas() {
        return PersonasList.personas ;
    }

    @Override
    public List<DeporteDTO> listaDeportes() {
        return PersonasList.deporteslist;
    }

    @Override
    public String nombreDeporte(String nombre) {
        Optional<DeporteDTO> deportes = PersonasList.deporteslist.stream().filter(deporte -> deporte.getNombre().equals(nombre.toUpperCase())).map(deporte -> new DeporteDTO(deporte.getNombre(), deporte.getNivel())).findFirst();

        try {
         /*for(DeporteDTO deportes : PersonasList.deporteslist)
         {
             if(deportes.getNombre().equals(nombre))
             {
                 return  deportes;
             }
         }

         return null;  */
            if (deportes.isPresent()) {
                return (deportes.get().toString());
            } else {
                throw new Exception("No existe ese deporte");
            }
        }catch (Exception e)
        {
            return e.getMessage();
        }

    }

}
