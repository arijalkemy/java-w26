package com.ejercicio.manejodeblogs.repository.implementations;

import com.ejercicio.manejodeblogs.entity.BlogEntry;
import com.ejercicio.manejodeblogs.repository.interfaces.IBlogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepository implements IBlogRepository {
    private List<BlogEntry> blogEntryList = new ArrayList<BlogEntry>();

    @Override
    public BlogEntry add(BlogEntry blogEntry) {
        BlogEntry exist = getById(blogEntry.getId());
        if(exist == null) {
            blogEntryList.add(blogEntry);
            return blogEntry;
        }
        return null;
    }

    @Override
    public BlogEntry getById(int id) {
        Optional<BlogEntry> result = blogEntryList
                .stream()
                .filter(blogEntry -> blogEntry.getId() == id)
                .findFirst();

        if (result.isPresent()) return result.get();
        return null;
    }

    @Override
    public List<BlogEntry> getAll() {
        return blogEntryList;
    }
}
