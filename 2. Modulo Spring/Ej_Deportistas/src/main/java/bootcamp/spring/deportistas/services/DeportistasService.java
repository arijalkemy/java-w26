package bootcamp.spring.deportistas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import bootcamp.spring.deportistas.models.Deportista;
import bootcamp.spring.deportistas.repositories.DeportistasRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class DeportistasService {
    
    private final DeportistasRepository deportistasRepository;

    public List<Deportista> obtenerDeportistas(){
        return deportistasRepository.getAll();
    }
}
