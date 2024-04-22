package org.ggomezr.blog.application.service.interfaces;

import org.ggomezr.blog.domain.dto.BlogEntryDTO;

import java.util.List;

public interface IBlogService {

    String createBlogEntry(BlogEntryDTO blogEntryDTO);

    List<BlogEntryDTO> getAllBlogEntries();

    BlogEntryDTO getBlogEntryById(Integer id);
}
