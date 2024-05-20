package bootcamp.bendezujonathan.perlas.service.implementations;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import bootcamp.bendezujonathan.perlas.dto.request.JewerlyRequest;
import bootcamp.bendezujonathan.perlas.dto.response.JewerlyResponse;
import bootcamp.bendezujonathan.perlas.dto.response.MessageResponse;
import bootcamp.bendezujonathan.perlas.exceptions.NotFoundException;
import bootcamp.bendezujonathan.perlas.model.Jewerly;
import bootcamp.bendezujonathan.perlas.repository.interfaces.JewerlyRepository;
import bootcamp.bendezujonathan.perlas.service.interfaces.JewerlyService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JewerlyServiceImpl implements JewerlyService {
    
    private final JewerlyRepository repository;

    private static final ModelMapper MAPPER = new ModelMapper();

    @Override
    public MessageResponse create(JewerlyRequest toCreate) {
       Jewerly newJ = requestToModel(toCreate);
       repository.save(newJ);
       return new MessageResponse(String.format("Jewerly created with ID [%d]", newJ.getNroIdentificatorio()));
    }

    @Override
    public MessageResponse delete(long id) {
        JewerlyResponse found = findById(id);
        Jewerly toDelete = responseToModel(found);
        toDelete.setVentaONo(false);
        repository.save(toDelete);
        return new MessageResponse(String.format("Jewerly Deleted with id [%d]", id));
    }

    @Override
    public List<JewerlyResponse> findAll() {
        return repository.findByVentaONo(true)
        .stream()
        .map(this::modelToResponse)
        .toList();
    }

    @Override
    public JewerlyResponse findById(long id) {
       Jewerly found = repository.findByNroIdentificatorioAndVentaONo(id, true)
                                .orElseThrow(() -> new NotFoundException(String.format("No Jewery for ID [%d]", id)));
        return modelToResponse(found);
    }

    @Override
    public void update(long id, JewerlyRequest toUpdate) {
       JewerlyResponse found = findById(id);
       Jewerly model = responseToModel(found);
       model.update(requestToModel(toUpdate));
       repository.save(model);
    }
    


    private Jewerly requestToModel(JewerlyRequest toTransform) {
        return MAPPER.map(toTransform, Jewerly.class);
    }

    private JewerlyResponse modelToResponse(Jewerly toTransform) {
        return MAPPER.map(toTransform, JewerlyResponse.class);
    }

    private Jewerly responseToModel(JewerlyResponse toTransform) {
        return MAPPER.map(toTransform, Jewerly.class);
    }
}
