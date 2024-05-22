package bootcamp.bendezujonathan.elastichsearch.service.implementations;

import java.util.List;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import bootcamp.bendezujonathan.elastichsearch.dto.request.EmployeeRequest;
import bootcamp.bendezujonathan.elastichsearch.dto.response.EmployeeResponse;
import bootcamp.bendezujonathan.elastichsearch.model.Ciudad;
import bootcamp.bendezujonathan.elastichsearch.model.Employee;
import bootcamp.bendezujonathan.elastichsearch.model.Provincia;
import bootcamp.bendezujonathan.elastichsearch.repository.interfaces.EmployeeRepository;
import bootcamp.bendezujonathan.elastichsearch.service.interfaces.EmployeeService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements EmployeeService {
    
    private final EmployeeRepository repository;
    private ModelMapper mapper;

    @PostConstruct
    public void init() {
        mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    @Override
    public List<EmployeeResponse> findAll() {
        Iterable<Employee> found = repository.findAll();
        return StreamSupport.stream(found.spliterator(), false)
                            .map(this::modelToResponse)
                            .toList();
    }

    @Override
    public void create(EmployeeRequest req) {
        Employee emp = requestToModel(req);
        repository.save(emp);
    }
    

    private Employee requestToModel(EmployeeRequest request) {
        Provincia prov = mapper.map(request.getProvincia(), Provincia.class);
        Ciudad ciudad = mapper.map(request.getCiudad(), Ciudad.class);
        return new Employee(null, request.getNombre(), request.getEdad(), ciudad, prov);
    }

    private EmployeeResponse modelToResponse(Employee model){
        return mapper.map(model, EmployeeResponse.class);
    }
}
