package org.mercadolibre.NotNullTeam.TestRepository;

import org.mercadolibre.NotNullTeam.model.Post;
import org.mercadolibre.NotNullTeam.model.Product;
import org.mercadolibre.NotNullTeam.model.Seller;
import org.mercadolibre.NotNullTeam.model.User;
import org.mercadolibre.NotNullTeam.repository.IPostRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Profile("test")
public class PostRepositoryTest implements IPostRepository {

    Map<Long, List<Post>> posts;

    public PostRepositoryTest() {
        this.posts = new HashMap<>();

        User sellerUser = User.builder().id(5L).name("user").build();
        Seller seller = Seller.builder().user(sellerUser).followersList(new ArrayList<>()).build();

        Product product = Product.builder()
                .id(1L)
                .name("Product1")
                .type("Chair")
                .brand("Gamer")
                .color("White")
                .notes("Very gamer with RGB")
                .build();

        Post post = Post.builder()
                .seller(seller)
                .date(LocalDate.now().minusDays(10))
                .product(product)
                .category(2)
                .price(100.0)
                .build();

        createPost(post);
    }

    @Override
    public Long createPost(Post post) {
        Long sellerId = post.getSeller().getUser().getId();

        if (!posts.containsKey(sellerId)) {
            posts.put(sellerId, new ArrayList<>(List.of(post)));
        }
        else {
            posts.get(sellerId).add(post);
        }

        return post.getId();
    }

    @Override
    public List<Post> getPostsByWeeksAgo(int weeks, Long sellerId) {
        return List.of();
    }
}
