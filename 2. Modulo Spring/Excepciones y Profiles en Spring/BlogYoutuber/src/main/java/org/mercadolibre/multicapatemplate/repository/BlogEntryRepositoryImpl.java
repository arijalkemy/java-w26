package org.mercadolibre.multicapatemplate.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mercadolibre.multicapatemplate.dto.BlogEntryResponseDTO;
import org.mercadolibre.multicapatemplate.entity.BlogEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogEntryRepositoryImpl{

    private List<BlogEntry> blogEntryList;

    public BlogEntryRepositoryImpl() {
        this.blogEntryList = new ArrayList<>();
    }

    public Integer save(BlogEntry blogEntry){
        if (this.find(blogEntry.getId()) == null){
            this.blogEntryList.add(blogEntry);
            return blogEntry.getId();
        } else {
            return -1;
        }
    }

    public BlogEntry find(int id){
        return blogEntryList
                .stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<BlogEntry> getAll(){
        return blogEntryList;
    }
}
