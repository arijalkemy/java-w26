package ejercicioDeportista.ejercicioDeportista.servicio.impl;

import ejercicioDeportista.ejercicioDeportista.entidades.Deporte;
import ejercicioDeportista.ejercicioDeportista.entidades.Persona;
import ejercicioDeportista.ejercicioDeportista.repositorios.DeporteRepositorio;
import ejercicioDeportista.ejercicioDeportista.servicio.IDeportePersonaService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DeporteServiceImpl implements IDeportePersonaService {

    private DeporteRepositorio deporteRepositorio;

    public DeporteServiceImpl() {
        this.deporteRepositorio = new DeporteRepositorio(
                List.of(new Deporte("Futbol", "Profesional"),
                        new Deporte("Natación", "Amateur"),
                        new Deporte("Tenis", "Intermedio")
                        )
        );
    }

    @Override
    public List<Deporte> findAllSports() {
        return this.deporteRepositorio.obtenerDeportes();
    }
    public String findSportsByName(String name) {
      return this.deporteRepositorio.obtenerDeportesPorNombre(name);
    }


}
