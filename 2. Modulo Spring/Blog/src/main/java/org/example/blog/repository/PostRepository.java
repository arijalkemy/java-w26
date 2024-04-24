package org.example.blog.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.blog.dto.PostEntryDto;
import org.example.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository implements IPostRepository {

    List<EntradaBlog> blogEntries = new ArrayList<>();

    @Override
    public String addNewPost(PostEntryDto entryPost) {
        EntradaBlog entryBlog = new EntradaBlog(entryPost.getPostName(), entryPost.getAuthorName(), entryPost.getPublishedDate());
        blogEntries.add(entryBlog);
        return "Blog added successfully";
    }

    @Override
    public EntradaBlog getPostById(int id) {
        return blogEntries.stream().filter(entryBlog -> entryBlog.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<EntradaBlog> getAllPosts() {
        return blogEntries;
    }
}
