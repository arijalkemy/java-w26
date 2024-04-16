package bootcamp.spring.covid.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bootcamp.spring.covid.models.Sintoma;
import bootcamp.spring.covid.repositories.SintomasRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SintomasService {

    private final SintomasRepository sintomasRepository;

    public List<Sintoma> obtenerSintomas(){
        return sintomasRepository.getAll();
    }

    public Optional<Sintoma> obtenerSintomaPorNombre(String nombreSintoma){
        return sintomasRepository.find(nombreSintoma);
    }
}
