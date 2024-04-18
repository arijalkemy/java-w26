package com.practicaSpring.blog.service;

import com.practicaSpring.blog.dto.BlogEntryDTO;

import java.util.List;

public interface IBlogEntryService {
    Long createEntry(BlogEntryDTO blogEntry);

    BlogEntryDTO getEntryById(Long id);

    List<BlogEntryDTO> getAllEntries();
}
