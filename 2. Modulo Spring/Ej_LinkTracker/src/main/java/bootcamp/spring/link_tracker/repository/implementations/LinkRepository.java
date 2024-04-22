package bootcamp.spring.link_tracker.repository.implementations;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import bootcamp.spring.link_tracker.model.Link;
import bootcamp.spring.link_tracker.repository.interfaces.ILinkRepository;

@Repository
public class LinkRepository implements ILinkRepository{

    private static Map<Integer,Link> links = new HashMap<>();

    @Override
    public Integer save(Link link) {

        Integer id = links.size() + 1;
        link.setId(id);
        links.put(id, link);
        return id;
    }

    @Override
    public Link findById(Integer id) {
        return links.getOrDefault(id, null);
    }

    @Override
    public void sumRedirect(Link link) {
        links.get(link.getId()).aumentarVecesRedireccionado();
    }

    @Override
    public void invalidateLink(Integer id) {
        links.get(id).setHabilitado(false);
    }
	
}
