package org.example.blog.repository;

import org.example.blog.dto.PostEntryDto;
import org.example.blog.entity.EntradaBlog;

import java.util.List;

public interface IPostRepository {
    String addNewPost(PostEntryDto entryPost);
    List<EntradaBlog> getAllPosts();
    EntradaBlog getPostById(int id);
}
