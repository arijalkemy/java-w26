package bootcamp.sprint.grupo02.sprintI.repository.implementations;

import bootcamp.sprint.grupo02.sprintI.dto.response.PostPromoResponseDTO;
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
        Product product =  new Product(1, "Termo", "Tipo 1", "Stanley", "Verde", "Importado");
        Product product2 =  new Product(2, "Mate", "Tipo 2", "Lumilagro", "gris", "Bueno, bonito y barato");
        Product product3 =  new Product(3, "Bombilla", "Tipo 3", "Acerox", "acero", "Fabricada con acero inoxidable");
        Product product4 =  new Product(4, "Yerba", "Tipo 4", "Caballo negro", "verde", "Orgánica");

        Post post = new Post(1, 1, LocalDate.now(), 1, 100.0, product , 0, false);
        Post post2 = new Post(2, 1, LocalDate.of(2024, 3, 13), 1, 2000, product2 , 2, false);
        Post post3 = new Post(3, 2, LocalDate.of(2024, 2, 15), 1, 2000, product3 , 4, true);
        Post post4 = new Post(4, 2, LocalDate.of(2024, 3, 19), 1, 2000, product4 , 4, false);
        Post post5 = new Post(5, 2, LocalDate.of(2024, 4, 25), 1, 2000, product , 4, true);

        posts.add(post);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);
        posts.add(post5);
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Optional<Post> findById(int id) {
        return posts.stream().filter(p -> p.getId() == id).findFirst();
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

    @Override
    public List<Post> findWithPromo(int sellerId) {
        return posts.stream().filter(p -> p.isHasPromo() && p.getSellerId() == sellerId).toList();
    }

    @Override
    public Post removePromo(int postId) {
        Post post = findById(postId).get();
        post.setHasPromo(false);
        return post;
    }
}
