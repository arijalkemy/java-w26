package org.bootcamp.blog.service;

import org.bootcamp.blog.dto.BlogEntryDTO;

import java.util.List;

public interface BlogEntryService {

    BlogEntryDTO save(BlogEntryDTO blogEntryDTO);

    List<BlogEntryDTO> getAll();

    BlogEntryDTO getById(Integer id);

}
