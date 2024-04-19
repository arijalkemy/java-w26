package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.entity.BlogEntry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogEntryRepository {
    private List<BlogEntry> blogEntries;
    public BlogEntryRepository() {
        blogEntries = new ArrayList<>();
    }
    public List<BlogEntry> findAll() {
        return blogEntries;
    }
    public BlogEntry findById(Integer id) {
        return blogEntries.stream()
                .filter(entry -> entry.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    public Boolean existsById(Integer id) {
        return blogEntries.stream()
                .anyMatch(entry -> entry.getId().equals(id));
    }
    public void save(BlogEntry entry) {
        this.blogEntries.add(entry);
    }
}
