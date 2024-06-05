package com.deportista.demo.servicios;

import com.deportista.demo.dto.DTODeportista;
import com.deportista.demo.modelo.Deporte;
import com.deportista.demo.modelo.Persona;
import com.deportista.demo.repositorio.RepositorioDeportista;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioDeportista implements IServicioDeportista{
    //Atributos
    private RepositorioDeportista repo = new RepositorioDeportista();
    private List<DTODeportista> listaDTO = new ArrayList<>();

    public ServicioDeportista(){
    }

    @Override
    public List<Deporte> listarDeportes() {
        return repo.getListaDeporte();
    }

    @Override
    public Deporte obtenerDeporte(String deporte) {
        return repo.filtrarDeporte(deporte);
    }

    @Override
    public List<DTODeportista> listarDTOdeportista() {
        Deporte equipo = obtenerDeporte("Baloncesto");
        List<Persona> listaPersonas = repo.getListaPersonas();

        for(Persona deportista : listaPersonas){
            DTODeportista dtoDeportista = new DTODeportista();
            dtoDeportista.setNombre(deportista.getNombre());
            dtoDeportista.setApellido(deportista.getApellido());
            dtoDeportista.setDeporte(equipo.getNombre());
            listaDTO.add(dtoDeportista);
        }

        return listaDTO;
    }

}
