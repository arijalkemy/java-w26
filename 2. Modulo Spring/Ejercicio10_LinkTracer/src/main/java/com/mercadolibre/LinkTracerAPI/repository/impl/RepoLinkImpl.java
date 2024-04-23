package com.mercadolibre.LinkTracerAPI.repository.impl;

import com.mercadolibre.LinkTracerAPI.entity.Link;
import com.mercadolibre.LinkTracerAPI.repository.IRepoLink;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepoLinkImpl implements IRepoLink {
    List<Link> links = new ArrayList<>();
    @Override
    public Integer crearLink(Link link) {
        Link linkBuscar = links.stream().filter(link1 -> link1.equals(link)).findFirst().orElse(null);
        if (linkBuscar == null){
            links.add(link);
            return link.getId();
        }
        return null;
    }

    @Override
    public Link redirección(Integer id) {
        Link linkBuscar = links.stream().filter(link -> link.getId().equals(id)).findFirst().orElse(null);
        if (linkBuscar != null){
            linkBuscar.setCantRedireccion(linkBuscar.getCantRedireccion() + 1);
            return linkBuscar;
        }
        return null;
    }

    @Override
    public List<Link> obtenerTodos() {
        return links;
    }

    @Override
    public Link estadisticaLink(Integer id) {
        Link link = links.stream().filter(link1 -> link1.getId().equals(id)).findFirst().orElse(null);
        if (link != null){
            return link;
        }
        return null;
    }

    @Override
    public boolean validarLink(Integer id) {
        Link link = links.stream().filter(link1 -> link1.getId().equals(id)).findFirst().orElse(null);
        if (link != null){
            link.setValido(false);
            return true;
        }
        return false;
    }
}
