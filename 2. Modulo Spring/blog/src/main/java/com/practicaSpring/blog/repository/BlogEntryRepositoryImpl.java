package com.practicaSpring.blog.repository;

import com.practicaSpring.blog.dto.BlogEntryDTO;
import com.practicaSpring.blog.model.BlogEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BlogEntryRepositoryImpl implements IBlogEntryRepository{
    HashMap<Long, BlogEntry> blogEntries = new HashMap<>();

    @Override
    public List<BlogEntry> findAll() {
        return new ArrayList<>(this.blogEntries.values());
    }

    @Override
    public BlogEntry findById(Long id) {
        return this.blogEntries.get(id);
    }

    @Override
    public Long save(BlogEntryDTO blogEntry) {
        if(blogEntries.containsKey(blogEntry.getId())){
            return null;
        }
        blogEntries.put(blogEntry.getId(),
                new BlogEntry(blogEntry.getId(), blogEntry.getTitle(), blogEntry.getAuthor(), blogEntry.getPublishDate()));
        return blogEntry.getId();
    }
}
