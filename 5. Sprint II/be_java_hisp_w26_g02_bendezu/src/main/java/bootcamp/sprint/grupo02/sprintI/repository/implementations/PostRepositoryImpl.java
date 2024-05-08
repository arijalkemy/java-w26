package bootcamp.sprint.grupo02.sprintI.repository.implementations;

import bootcamp.sprint.grupo02.sprintI.model.Post;
import bootcamp.sprint.grupo02.sprintI.model.Product;
import bootcamp.sprint.grupo02.sprintI.repository.PostRepository;
import bootcamp.sprint.grupo02.sprintI.util.FileDataBaseUtil;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private List<Post> posts;
    private final FileDataBaseUtil<Post> postManager;
    

    public PostRepositoryImpl(FileDataBaseUtil<Post> fileDataBaseUtil) {
        this.postManager = fileDataBaseUtil;
        this.posts = fileDataBaseUtil.readFromJsonFile("post.json");
        
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
        boolean existed = remove(entity);

        if(!existed) {
            entity.setId(posts.size() + 1);
        }

        posts.add(entity);
        postManager.saveData(posts, "product.json");
    }

    @Override
    public boolean remove(Post entity) {
       
        boolean exists = this.posts
                .stream()
                .anyMatch(p -> p.getId() == entity.getId());

        if (exists) {
            this.posts.remove(entity);
            postManager.saveData(posts, "product.json");
        }

        return exists;
    }

    @Override
    public List<Post> findBySellerId(int sellerId) {
        return posts.stream().filter(p -> p.getSellerId() == sellerId).toList();
    }
}
