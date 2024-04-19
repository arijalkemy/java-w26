package org.example.blog.repository;

import org.example.blog.dto.BlogDTO;
import org.example.blog.model.EntradaBlog;

import java.util.List;

public interface IRepository {
    boolean exist(int id);
    int add(EntradaBlog blog);
    EntradaBlog getById(int id);
    List<EntradaBlog> getAll();
}
