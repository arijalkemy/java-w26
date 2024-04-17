package org.example.covid.service.imp;

import org.example.covid.dto.GravedadSintomaDTO;
import org.example.covid.dto.PersonaNombresDTO;
import org.example.covid.model.Sintoma;
import org.example.covid.repository.PersonaRepository;
import org.example.covid.repository.SintomasRepository;
import org.example.covid.service.ISintomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SintomaServiceImp implements ISintomaService {

    @Override
    public ResponseEntity<List<Sintoma>> getSintomas() {
        List<Sintoma> sintomas = SintomasRepository.getSintomas();

        if(sintomas.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(sintomas, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GravedadSintomaDTO> getGravedadSintoma(String sintoma) {
        Sintoma sintomaEncontrado = SintomasRepository.getSintomas().stream()
                .filter(s -> s.getNombre().equals(sintoma)).findFirst().orElse(null);
        if(sintomaEncontrado == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(
                new GravedadSintomaDTO(sintomaEncontrado.getNivelDeGravedad()),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<List<PersonaNombresDTO>> getPersonasDeRiesgo() {
        List<PersonaNombresDTO> personasDeRiesgo = PersonaRepository.getPersonas().stream()
                .filter(p -> p.getSintomas().size() > 0 && p.getEdad() > 60)
                .map(p-> new PersonaNombresDTO(
                        p.getNombre(),
                        p.getApellido()
                )).toList();
        if(personasDeRiesgo.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(personasDeRiesgo, HttpStatus.OK);
    }
}
