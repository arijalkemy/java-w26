package bootcamp.base.miniseries.service.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import bootcamp.base.miniseries.dto.response.MiniSerieResponse;
import bootcamp.base.miniseries.model.MiniSerie;
import bootcamp.base.miniseries.repository.interfaces.IMiniSerieRepository;
import bootcamp.base.miniseries.service.interfaces.IMiniSerieService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MiniSerieService implements IMiniSerieService {

    private final IMiniSerieRepository repository;

    @Override
    public List<MiniSerieResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public MiniSerieResponse findById(long id) {
        return this.convertToDto(this.repository.findById(id).get());
    }

    private MiniSerieResponse convertToDto(MiniSerie miniSerie){
        return new MiniSerieResponse(miniSerie.getId(), miniSerie.getName(), miniSerie.getRating(), miniSerie.getAmountOfAwards());
    }

}
