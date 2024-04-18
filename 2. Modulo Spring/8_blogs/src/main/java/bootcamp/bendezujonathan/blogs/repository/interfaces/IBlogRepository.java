package bootcamp.bendezujonathan.blogs.repository.interfaces;

import java.util.List;

import bootcamp.bendezujonathan.blogs.model.EntradaDeBlog;

public interface IBlogRepository {
	
    List<EntradaDeBlog> findAll();

    void save(EntradaDeBlog save);

    boolean exists(EntradaDeBlog toCheck);
}
