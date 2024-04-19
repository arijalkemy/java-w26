package org.mercadolibre.multicapatemplate.repository;

import org.mercadolibre.multicapatemplate.entity.BlogEntry;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogEntryRepositoryImpl{

    private final List<BlogEntry> blogEntryList;

    public BlogEntryRepositoryImpl() {
        this.blogEntryList = new ArrayList<>();
    }

    public Integer save(BlogEntry blogEntry){
        if (this.getById(blogEntry.getId()) == null){
            blogEntry.setPublicationDate(LocalDate.now());
            this.blogEntryList.add(blogEntry);
            return blogEntry.getId();
        } else {
            return -1;
        }
    }

    public BlogEntry getById(int id){
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
