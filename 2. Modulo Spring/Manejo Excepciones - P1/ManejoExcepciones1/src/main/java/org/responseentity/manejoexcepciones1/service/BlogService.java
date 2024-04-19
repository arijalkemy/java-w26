package org.responseentity.manejoexcepciones1.service;

import org.responseentity.manejoexcepciones1.dto.BlogDTO;
import org.responseentity.manejoexcepciones1.entity.BlogEntity;

import java.util.List;

public interface BlogService {
    String createBlogEntry(BlogDTO blog);
    BlogEntity getBlogEntryById(int id);
    List<BlogEntity> getAllTheBlogEntries();
}
