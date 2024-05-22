package bootcamp.bendezujonathan.cloth.service.implementations;


import bootcamp.bendezujonathan.cloth.dto.request.ClothRequest;
import bootcamp.bendezujonathan.cloth.dto.response.ClothResponse;
import bootcamp.bendezujonathan.cloth.exception.NotFoundException;
import bootcamp.bendezujonathan.cloth.model.Cloth;
import bootcamp.bendezujonathan.cloth.repository.interfaces.ClothRepository;
import bootcamp.bendezujonathan.cloth.service.interfaces.ClothService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClothServiceImpl implements ClothService {

    private final ClothRepository clothRepository;
    private final ModelMapper mapper;

    @Override
    public void create(ClothRequest request) {
        Cloth model = requestToModel(request);
        clothRepository.save(model);
    }

    @Override
    public void batch(List<ClothRequest> requests) {
        List<Cloth> models = requests.stream()
                .map(this::requestToModel)
                .toList();
        clothRepository.saveAll(models);
    }

    @Override
    public void update(Long id, ClothRequest request) {
        Cloth model = findModelById(id);
        mapper.map(request, model);
        clothRepository.save(model);
    }

    @Override
    public void delete(Long codigo) {
        Cloth model = findModelById(codigo);
        clothRepository.delete(model);
    }

    @Override
    public ClothResponse findById(Long id) {
        return modelToResponse(findModelById(id));
    }

    public Cloth findModelById(Long id) {
        return clothRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("No Cloth Found for ID [%d]", id)));
    }

    @Override
    public List<ClothResponse> findAll() {
        return modelListToResponse(clothRepository.findAll());
    }

    @Override
    public List<ClothResponse> findAllBySize(String size) {
        return modelListToResponse(clothRepository.findAllByTalle(size));
    }

    @Override
    public List<ClothResponse> findAllByName(String name) {
        return modelListToResponse(clothRepository.findAllByNombreContaining(name));
    }

    private Cloth requestToModel(ClothRequest req){
        return mapper.map(req, Cloth.class);
    }

    public  ClothResponse modelToResponse(Cloth cloth){
        return mapper.map(cloth, ClothResponse.class);
    }

    private List<ClothResponse> modelListToResponse(List<Cloth> models) {
        return models.stream()
                .map(this::modelToResponse)
                .toList();
    }
}
