package bootcamp.spring.blog.service.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import bootcamp.spring.blog.exceptions.AlreadyExistsException;
import bootcamp.spring.blog.exceptions.NotFoundException;
import bootcamp.spring.blog.model.EntradaBlog;
import bootcamp.spring.blog.repository.interfaces.IEntradaBlogRepository;
import bootcamp.spring.blog.service.interfaces.IEntradaBlogService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EntradaBlogService implements IEntradaBlogService {

    private final IEntradaBlogRepository entradaBlogRepository;

    @Override
    public Integer save(EntradaBlog obj) {
        entradaBlogRepository
                .save(obj)
                .ifPresent(entradaBlog -> {
                    throw new AlreadyExistsException("Ya existe el objeto " + entradaBlog.getId());
                });
        return obj.getId();
    }

    @Override
    public EntradaBlog searchById(Integer id) {
        return entradaBlogRepository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<EntradaBlog> searchAll() {
        return entradaBlogRepository.findAll();
    }

}
