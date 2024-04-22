package com.link.link.repository.impl;

import com.link.link.entity.Link;
import com.link.link.repository.ILinkRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImpl implements ILinkRepository {
    private List<Link> listaLinks;

    public LinkRepositoryImpl() {
        this.listaLinks = new ArrayList<>();
    }

    @Override
    public Long crearLink(Link url) {
        listaLinks.add(url);
        return url.getId();
    }

    public Long getId() {
        return Long.valueOf(listaLinks.size() + 1);
    }

    @Override
    public String buscarUrl(Long id) {

        Link respuesta = listaLinks.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if(respuesta == null)
        {
            return null;
        }
        return respuesta.getUrlRediccion();
    }

}
