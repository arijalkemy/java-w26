package org.bootcamp.blog.repository;

import org.bootcamp.blog.exception.ExistObjectException;
import org.bootcamp.blog.exception.NotFoundException;
import org.bootcamp.blog.model.BlogEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogEntryRepository {

    private List<BlogEntry> blogList;

    public BlogEntryRepository() {
        this.blogList = new ArrayList<>();
    }

    public BlogEntry save(BlogEntry blogEntry){

        if(validator(blogEntry.getId()))
            return new BlogEntry();

        blogList.add(blogEntry);
        return blogEntry;
    }

    public boolean validator(int id){
        return blogList.stream()
                .anyMatch(blogEntry -> blogEntry.getId() == id) ;
    }

    public List<BlogEntry> findAll(){
        return blogList;
    }

    public BlogEntry findById(int id){
        if(validator(id))
            return blogList.stream().filter(blogEntry -> blogEntry.getId() == id).findFirst().get();

        throw new NotFoundException("No se encontro la entrada del blog con ID " + id);
    }

}
