package com.example.deportistas.Service;

import com.example.deportistas.Entity.Deporte;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeporteServiceImpl implements DeporteService{

    //Dummy List
    private List<Deporte> deportes = List.of(
            new Deporte(1,"Natacion", 10),
            new Deporte(2,"Esgrima", 9),
            new Deporte(3,"Arqueria", 8),
            new Deporte(4,"Futbol", 12)
    );

    @Override
    public List<Deporte> todosLosDeportes() {
        return deportes;
    }

    @Override
    public int busquedaPorNombre(String nombre) {
        for(Deporte deporte: deportes){
            if(nombre.toLowerCase().equals(deporte.getNombre().toLowerCase())){
                return deporte.getNivel();
            }
        }
        return -1;
    }


}
