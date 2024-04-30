package bootcamp.sprint.grupo02.sprintI.repository;

import bootcamp.sprint.grupo02.sprintI.model.Post;

import java.util.List;

public interface PostRepository extends Repository<Post>{

    List<Post> findBySellerId(int sellerId);
    List<Post> findByPromoPost(int sellerId);
    List<Post> findByPromoPostProductByType(int sellerId, String type);
}
