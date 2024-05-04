package com.javabootcamp.linktracker.repository;

import com.javabootcamp.linktracker.model.Link;
import com.javabootcamp.linktracker.repository.impl.ILinkRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository implements ILinkRepository {
    private HashMap<Integer, Link> todosLosLinks = new HashMap<>();

    @Override
    public Map<Integer, Link> obtenerTodosLosLinks() {
        return todosLosLinks;
    }

    @Override
    public Link obtenerPorId(Integer id) {
        return todosLosLinks.get(id);
    }

    @Override
    public void editarLink(Link link) {
      todosLosLinks.remove(link.getId());
      todosLosLinks.put(link.getId(),link);
    }

    @Override
    public void cargarLink(Link link)
    {
        link.setValido(true);
        todosLosLinks.put(link.getId(), link);
    }

    public void subirUnaVistaPorId(Integer id){
        todosLosLinks.get(id).setVistas(todosLosLinks.get(id).getVistas() +1);
    }
}
