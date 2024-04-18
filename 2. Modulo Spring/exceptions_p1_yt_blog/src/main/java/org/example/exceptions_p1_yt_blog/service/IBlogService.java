package org.example.exceptions_p1_yt_blog.service;

import org.example.exceptions_p1_yt_blog.dto.BlogDTO;

import java.util.List;

public interface IBlogService {
    List<BlogDTO> getAll();
    BlogDTO findById(Integer id);
    int save(BlogDTO blogEntryDto);
}
