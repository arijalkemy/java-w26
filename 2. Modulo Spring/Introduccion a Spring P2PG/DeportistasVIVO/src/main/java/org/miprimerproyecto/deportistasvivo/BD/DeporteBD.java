package org.miprimerproyecto.deportistasvivo.BD;

import org.miprimerproyecto.deportistasvivo.DTO.DeporteDTO;

import java.util.ArrayList;
import java.util.List;

public class DeporteBD {
   private static final ArrayList<DeporteDTO> listaDeDeportes = new ArrayList<>();
    static{
        listaDeDeportes.add(new DeporteDTO(123, "Futbol", 4));
        listaDeDeportes.add(new DeporteDTO(124, "Natacion", 1));
        listaDeDeportes.add(new DeporteDTO(125, "Tenis", 2));
        listaDeDeportes.add(new DeporteDTO(126, "Rugby", 3));
        listaDeDeportes.add(new DeporteDTO(127, "Atletismo", 4));

    }


    public List<DeporteDTO> getDeportes(){
        return listaDeDeportes.stream().toList();
    }

    public DeporteDTO getDeporteByName(String nombre){
        return listaDeDeportes.stream().filter(x -> x.getNombre().equals(nombre)).findFirst().get();
    }
}
