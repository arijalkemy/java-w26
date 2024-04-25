package bootcamp.sprint.grupo02.sprintI.repository.implementations;

import bootcamp.sprint.grupo02.sprintI.model.Post;
import bootcamp.sprint.grupo02.sprintI.model.Product;
import bootcamp.sprint.grupo02.sprintI.repository.PostRepository;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private List<Post> posts;

    

    public PostRepositoryImpl() {
        this.posts = new ArrayList<>();
        Product product =  new Product(1, "Termo", "Tipo 1", "Stanley", "Verde", "Muy caro para lo que es");
        Product product2 =  new Product(2, "Termo2", "Tipo 2", "Lumilagro", "gris", "Bueno, bonito y barato");

        Post post = new Post(1, 1, LocalDate.now(), 1, 100.0, product , 0, false);
        Post post2 = new Post(2, 1, LocalDate.of(2024, 4, 22), 1, 2000, product2 , 2, false);
        Post post3 = new Post(3, 2, LocalDate.of(2024, 4, 22), 1, 2000, product , 4, false);

        posts.add(post);
        posts.add(post2);
        posts.add(post3);
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Optional<Post> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void add(Post entity) {
        posts.add(entity);
    }

    @Override
    public void remove(Post entity) {

    }

    @Override
    public List<Post> findBySellerId(int sellerId) {
        return posts.stream().filter(p -> p.getSellerId() == sellerId).toList();
    }
}
