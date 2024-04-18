package ejercicioDeportista.ejercicioDeportista.servicio;

import ejercicioDeportista.ejercicioDeportista.entidades.Deporte;

import java.util.List;

public interface IDeportePersonaService {
    public List<Deporte> findAllSports();
    public String findSportsByName(String name);
}
