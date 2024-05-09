package org.mercadolibre.NotNullTeam.bootstrap;

import org.mercadolibre.NotNullTeam.model.*;
import org.mercadolibre.NotNullTeam.repository.IBuyerRepository;
import org.mercadolibre.NotNullTeam.repository.IPostRepository;
import org.mercadolibre.NotNullTeam.repository.ISellerRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@Profile("test")
public class BootstrapTest implements InitializingBean {

    @Autowired
    private IBuyerRepository buyerRepository;

    @Autowired
    private ISellerRepository sellerRepository;

    @Autowired
    private IPostRepository postRepository;

    @Override
    public void afterPropertiesSet() {
        Buyer buyerOne = Buyer.builder()
                .user(User.builder()
                        .id(3L)
                        .name("Buyer1")
                        .build()
                )
                .followedList(new ArrayList<>())
                .build();

        Seller sellerOne = Seller.builder()
                .user(User.builder()
                        .id(2L)
                        .name("Seller1")
                        .build()
                )
                .followersList(new ArrayList<>())
                .build();

        Product product = Product.builder()
                .id(1L)
                .name("Product1")
                .type("Gamer")
                .brand("Brand1")
                .color("Color1")
                .notes("Notes1")
                .build();

        Post post = Post.builder()
                .id(Post.fetchId())
                .seller(sellerOne)
                .date(LocalDate.now().minusDays(10))
                .product(product)
                .category(100)
                .price(100.0)
                .build();

        buyerOne.addNewFollowed(sellerOne);

        buyerRepository.save(buyerOne);

        sellerRepository.save(sellerOne);

        postRepository.createPost(post);
    }
}
