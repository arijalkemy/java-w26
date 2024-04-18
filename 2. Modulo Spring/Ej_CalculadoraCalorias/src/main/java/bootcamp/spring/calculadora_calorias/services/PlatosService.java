package bootcamp.spring.calculadora_calorias.services;

import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.stereotype.Service;

import bootcamp.spring.calculadora_calorias.models.Plato;
import bootcamp.spring.calculadora_calorias.models.dtos.PlatoDTO;
import bootcamp.spring.calculadora_calorias.repositories.IPlatoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlatosService implements IExternalPlatosService, IInternalPlatosService{

    private final IPlatoRepository platoRepository;



    @Override
    public Optional<PlatoDTO> searchByNameWithCalories(String name, Integer grams) throws NameNotFoundException {
        Optional<Plato> plato = this.searchByName(name);
        if(plato.isEmpty()){
            throw new NameNotFoundException();
        }
        PlatoDTO platoDTO = new PlatoDTO(plato.get());
        platoDTO.setCantidadCalorias(grams);
        return Optional.of(platoDTO);
    }



    @Override
    public Optional<Plato> searchByName(String name) {
        return platoRepository.findByName(name);
    }
}
