package com.example.link.repositorios.impl;

import com.example.link.modelo.Link;
import com.example.link.repositorios.interfaces.ILinkRepositorio;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class LinkRepositorio implements ILinkRepositorio {

    private List<Link> links = new ArrayList<>();

    @Override
    public void guardarLink(Link link) {
        links.add(link);
    }

    @Override
    public Optional<Link> buscarPorId(int id) {
        System.out.println(links);
        return links
                .stream().filter( l -> l.getId() == id)
                .findFirst();
    }

    @Override
    public void guardar(Link link) {
        for (int i = 0; i < links.size(); i++) {
            if (links.get(i).getId() == link.getId()) {
                links.set(i, link);
            }
        }
        links.add(link);
    }

}
