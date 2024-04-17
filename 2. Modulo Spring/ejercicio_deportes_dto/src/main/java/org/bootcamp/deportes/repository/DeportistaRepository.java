package org.bootcamp.deportes.repository;

import org.bootcamp.deportes.domain.Deporte;
import org.bootcamp.deportes.domain.Persona;
import org.bootcamp.deportes.restcontroller.dto.DeporteDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeportistaRepository {

    private static Map<Deporte, List<Persona>> deportistas;

    public DeportistaRepository() {
        this.deportistas = new HashMap<>();
    }

    public static Map<Deporte, List<Persona>> getDeportistas() {
        return deportistas;
    }

    public static void setDeportistas(Map<Deporte, List<Persona>> deportistas) {
        DeportistaRepository.deportistas = deportistas;
    }

    public void guardarDeportistas(Deporte deporte, List<Persona> personas){
        List<Persona> deportistas = this.deportistas.get(deporte);
        if(deportistas == null){
            this.deportistas.put(deporte, personas);
        }else{
            deportistas.addAll(personas);
            this.deportistas.replace(deporte, deportistas);
        }
        System.out.println("¡Deportistas guardados con exitos!");
    }

    public List<Deporte> obtenerDeportes(){
        return this.deportistas.keySet().stream().toList();
    }

    public Deporte obtenerNivelPorNombreDeporte (String nombreDeporte){
        return new Deporte(this.deportistas.keySet().stream()
                .filter(deporte -> deporte.getNombre().equalsIgnoreCase(nombreDeporte))
                .findFirst().get().getNivel());
    }

    public Map<Deporte, List<Persona>> obtenerPersonasPorDeporte(){
        return this.deportistas;
    }
}
