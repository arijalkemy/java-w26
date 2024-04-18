package com.practicaSpring.blog.repository;

import com.practicaSpring.blog.dto.BlogEntryDTO;
import com.practicaSpring.blog.model.BlogEntry;

import java.util.List;

public interface IBlogEntryRepository {
    List<BlogEntry> findAll();
    BlogEntry findById(Long id);
    Long save(BlogEntryDTO blogEntry);
}
