package com.example.starwars.servicio;

import com.example.starwars.dto.DTOPersonaje;
import com.example.starwars.modelo.Personaje;
import com.example.starwars.repositorio.RepositorioPersonaje;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioPersonaje implements IServicioPersonaje{
    //Atributos
    private RepositorioPersonaje miRepo = new RepositorioPersonaje();
    private List<DTOPersonaje> listaDTOPersonaje = new ArrayList<>();
    private List<Personaje> listaPersonaje = new ArrayList<>();

    @Override
    public List<Personaje> generarListaPersonaje() {
        return miRepo.getLista_personaje();
    }

    @Override
    public List<DTOPersonaje> generarListaPersonajePorFiltro(String filtro) {
            //Limpia la lista de filtrado
            listaDTOPersonaje.removeAll(listaDTOPersonaje);
            //Obtiene el listado de personajes a partir del filtro por nombre
            listaPersonaje = miRepo.filtrarRepositorioPersonaje(filtro);
            for (Personaje miPersonaje : listaPersonaje){
                DTOPersonaje miDTOPersonaje = new DTOPersonaje();
                miDTOPersonaje.setNombre(miPersonaje.getNombre());
                miDTOPersonaje.setAltura(miPersonaje.getAltura()+"");
                miDTOPersonaje.setMasa(miDTOPersonaje.getMasa()+"");
                miDTOPersonaje.setGenero(miPersonaje.getGenero());
                miDTOPersonaje.setEspecie(miPersonaje.getEspecie());
                miDTOPersonaje.setPlaneta_natal(miPersonaje.getPlaneta_natal());
                listaDTOPersonaje.add(miDTOPersonaje);
            }
        return listaDTOPersonaje;
    }
}
