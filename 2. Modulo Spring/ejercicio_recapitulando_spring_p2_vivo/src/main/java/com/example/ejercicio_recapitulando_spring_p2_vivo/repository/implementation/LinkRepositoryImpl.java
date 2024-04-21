package com.example.ejercicio_recapitulando_spring_p2_vivo.repository.implementation;

import com.example.ejercicio_recapitulando_spring_p2_vivo.entity.Link;
import com.example.ejercicio_recapitulando_spring_p2_vivo.repository.ILinkRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepositoryImpl implements ILinkRepository {
    private List<Link> links;
    private int id;

    public LinkRepositoryImpl() {
        links = new ArrayList<>();
        id = 1;
    }

    @Override
    public Link save(Link link) {
        link.setLinkId(id);
        id++;
        links.add(link);
        return link;
    }

    @Override
    public Optional<Link> findLinkById(Integer id) {
        return links.stream().filter(
            v -> v.getLinkId().intValue() == id.intValue()
        ).findFirst();
    }

    @Override
    public void delete(Link link) {
        links.remove(link);
    }
}
