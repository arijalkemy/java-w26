package bootcamp.bendezujonathan.blogs.repository.implementations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import bootcamp.bendezujonathan.blogs.model.EntradaDeBlog;
import bootcamp.bendezujonathan.blogs.repository.interfaces.IBlogRepository;


@Repository
public class BlogRepository implements IBlogRepository {

    private List<EntradaDeBlog> blogs;

    BlogRepository(){
        this.blogs = new ArrayList<>(List.of(new EntradaDeBlog(1, "AA", "A", LocalDate.now().toString())));
    }

    @Override
    public List<EntradaDeBlog> findAll() {
        return blogs;
    }

    @Override
    public void save(EntradaDeBlog save) {
        this.blogs.add(save);
    }

    @Override
    public boolean exists(EntradaDeBlog toCheck) {
        return this.blogs
                .stream()
                .anyMatch(blog -> toCheck.getId() == blog.getId());
    }
    
}
