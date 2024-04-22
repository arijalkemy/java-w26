package com.redirect.links.repositories;

import com.redirect.links.entities.Link;
import com.redirect.links.exceptions.BadRequestException;
import com.redirect.links.exceptions.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{

    private static Map<Integer, Link> linksRepo = new HashMap<>();


    @Override
    public Integer addLink(Link link) {
        //utilizo al tamaño del repositorio con un "contador"
        Integer id = linksRepo.size() + 1;
        linksRepo.put(id, link);

        return id;
    }

    @Override
    public Link showLink(Integer id, String password) {
        Link link = linksRepo.get(id);
        if (link == null){
            throw new NotFoundException("No existe un link relacionado al id proporcionado.");
        }else if(!link.getPassword().equals(password)){
            throw new BadRequestException("La contraseña de acceso al link es incorrecta.");
        }else{
            link.setCounter(link.getCounter() + 1);
            return link;
        }
    }

    @Override
    public Link giveLinkNoPassword(Integer id) {
        Link link = linksRepo.get(id);
        if (link == null) {
            throw new NotFoundException("No existe un link relacionado al id proporcionado.");
        }
        return link;
    }

    @Override
    public void invalidateLink(Integer id) {
        Link link = linksRepo.get(id);
        if (link == null) {
            throw new NotFoundException("No existe un link relacionado al id proporcionado.");
        }

        link.setValid(false);
    }


}
