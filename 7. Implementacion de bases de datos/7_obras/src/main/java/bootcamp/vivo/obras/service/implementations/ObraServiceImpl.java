package bootcamp.vivo.obras.service.implementations;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import bootcamp.vivo.obras.dto.request.ObraRequest;
import bootcamp.vivo.obras.dto.response.AutoResponse;
import bootcamp.vivo.obras.dto.response.EditorialResponse;
import bootcamp.vivo.obras.dto.response.ObraResponse;
import bootcamp.vivo.obras.model.Autor;
import bootcamp.vivo.obras.model.Editorial;
import bootcamp.vivo.obras.model.Obra;
import bootcamp.vivo.obras.repository.interfaces.ObraRepository;
import bootcamp.vivo.obras.service.interfaces.ObraService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ObraServiceImpl implements ObraService {
    
    private final ObraRepository repository;
    private ModelMapper mapper;

    @PostConstruct
    public void init() {
        mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    @Override
    public void create(ObraRequest req) {
        Obra obra = requestToModel(req);
        repository.save(obra);
    }

    @Override
    public void createInBatch(List<ObraRequest> req) {
        List<Obra> toCreate = req.stream()
                                .map(this::requestToModel)
                                .toList();
        repository.saveAll(toCreate);
    }


    @Override
    public List<ObraResponse> findAll() {
        return mapList(repository.findAll());
    }

    @Override
    public List<ObraResponse> findAllByAutor(String name) {
        return mapList(repository.findAllByAutorNombre(name));
    }

    @Override
    public List<ObraResponse> findAllByTitle(String title) {
        return mapList(repository.findAllByNombre(title));
    }

    @Override
    public List<ObraResponse> findTop5CantidadPaginas() {
        return mapList(repository.findTop5ByOrderByCantidadPaginas());
    }

    @Override
    public List<ObraResponse> findBeforeYear(int year) {
        LocalDate yearDate = LocalDate.of(year, 1, 1);
        return mapList(repository.findByFechaPrimerPublicacionBefore(yearDate));
    }

    @Override
    public List<ObraResponse> findByEditorialNombre(String name) {
        return mapList(repository.findByEditorialNombre(name));
    }


    private List<ObraResponse> mapList(List<Obra> models) {
        return models.stream()
        .map(this::modelToResponse)
        .toList();
    }

    private Obra requestToModel(ObraRequest req) {
        Editorial edi = mapper.map(req.getEditorial(), Editorial.class);
        Autor autor = mapper.map(req.getAutor(), Autor.class);
        return new Obra(null, req.getNombre(), autor, edi, req.getCantidadPaginas(), req.getFechaPrimerPublicacion());

    }

    private ObraResponse modelToResponse(Obra model) {
        EditorialResponse edi = mapper.map(model.getEditorial(), EditorialResponse.class);
        AutoResponse autor = mapper.map(model.getAutor(), AutoResponse.class);
        return new ObraResponse(model.getId(), model.getNombre(), model.getCantidadPaginas(), model.getFechaPrimerPublicacion(),  autor, edi);
    }


  

  



}
