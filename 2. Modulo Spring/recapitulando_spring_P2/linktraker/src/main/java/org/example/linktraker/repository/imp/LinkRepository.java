package org.example.linktraker.repository.imp;

import org.example.linktraker.dto.request.LinkCrearRequestDto;
import org.example.linktraker.entity.LinkPersonalizado;
import org.example.linktraker.repository.ILinkRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepository implements ILinkRepository {
    final private HashMap<Integer, LinkPersonalizado> links;

    public LinkRepository() {
        this.links = new HashMap<>();
    }

    @Override
    public int save(LinkCrearRequestDto link) {
        int id = links.size();
        links.put(id, new LinkPersonalizado(link));
        return id;
    }

    @Override
    public LinkPersonalizado findById(Integer id) {
        return links.get(id);
    }

    @Override
    public boolean updateLinkValidez(int linkId, boolean validar) {
        LinkPersonalizado linkEncontrado = links.get(linkId);
        if(linkEncontrado == null){
            return false;
        }
        linkEncontrado.setLinkValido(validar);
        return true;
    }
}
