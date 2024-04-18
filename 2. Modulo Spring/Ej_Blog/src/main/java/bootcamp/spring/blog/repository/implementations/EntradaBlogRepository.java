package bootcamp.spring.blog.repository.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import bootcamp.spring.blog.model.EntradaBlog;
import bootcamp.spring.blog.repository.interfaces.IEntradaBlogRepository;

@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository{

    Map<Integer,EntradaBlog> entradasBlog = new HashMap<>();
    
    @Override
    public Optional<EntradaBlog> save(EntradaBlog obj) {
        Optional<EntradaBlog> blogOptional = findById(obj.getId());
        if(blogOptional.isEmpty()){
            entradasBlog.put(obj.getId(), obj);
        }
        return blogOptional;
    }

    @Override
    public Optional<EntradaBlog> findById(Integer id) {
        if(entradasBlog.containsKey(id)){
            return Optional.of(entradasBlog.get(id));
        }
        return Optional.empty();
    }

    @Override
    public List<EntradaBlog> findAll() {
        return entradasBlog.values().stream().collect(Collectors.toList());
    }
	
}
