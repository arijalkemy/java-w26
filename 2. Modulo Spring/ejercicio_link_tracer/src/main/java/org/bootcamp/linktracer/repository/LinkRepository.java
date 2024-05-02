package org.bootcamp.linktracer.repository;

import org.bootcamp.linktracer.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepository {

    private Integer counterId;
    private List<Link> linkList;

    public LinkRepository(List<Link> linkList) {
        counterId = 1;
        this.linkList = linkList;
    }

    public Link save(Link link){
        // valida si existe, si no se actualiza
        if(linkList.contains(link)){
            linkList.set(linkList.indexOf(link), link);
        }else{
            link.setId(counterId++);
            link.setValidUrl(Boolean.TRUE);
            link.setVisitAmount(0);
            linkList.add(link);
        }
        return link;
    }

    public Optional<Link> findById (Integer id){
        if(id == null || id.equals(0))
            return Optional.empty();

        return linkList.stream()
                .filter(link -> link.getId().equals(id))
                .findFirst();
    }

}