package ejercicioDeportista.ejercicioDeportista.repositorios;

import ejercicioDeportista.ejercicioDeportista.entidades.Deporte;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeporteRepositorio{
    List<Deporte> deportes;

    public DeporteRepositorio(List<Deporte>deportes) {
        this.deportes = deportes;
    }

    public void agregarDeporte(Deporte ... deporte) {
        for(Deporte d: deporte){
            this.deportes.add(d);
        }
    }

    public List<Deporte> obtenerDeportes(){
        return this.deportes;
    }

    public String obtenerDeportesPorNombre(String nombre){
        Optional<Deporte> deporteEncontrado = this.deportes.stream()
                .filter(d -> d.getNombre().equalsIgnoreCase(nombre))
                .findFirst();

        if (deporteEncontrado.isPresent()) {
            String nivel = deporteEncontrado.get().getNivel();
            return  "El nivel del deporte " + nombre + " es: " + nivel;
        } else {
            return "El deporte " + nombre + " no fue encontrado";
        }
    }
}
