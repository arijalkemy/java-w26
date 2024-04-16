package bootcamp.spring.deportistas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bootcamp.spring.deportistas.models.Deporte;
import bootcamp.spring.deportistas.repositories.DeportesRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeportesService {

    private final DeportesRepository deportesRepository;

    public List<Deporte> obtenerDeportes() {
        return deportesRepository.getAll();
    }

    public Deporte obtenerDeporteAleatoriamente(){
        return deportesRepository.getRandomSport();
    }

    public Optional<Deporte> buscarDeporte(String nombreDeporte) {
        
     
        return deportesRepository.find(nombreDeporte);
    }
}
