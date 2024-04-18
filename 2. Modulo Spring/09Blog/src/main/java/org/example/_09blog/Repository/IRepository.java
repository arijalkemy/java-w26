package org.example._09blog.Repository;
import org.example._09blog.Model.Blog;

import java.util.Optional;
import java.util.List;

public interface IRepository {

    Blog find(int id);

    List<Blog> findAll();

    Blog save(Blog object);
}
