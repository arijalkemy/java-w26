package org.mercadolibre.NotNullTeam.utils;

import org.mercadolibre.NotNullTeam.DTO.request.post.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.product.ProductDTO;
import org.mercadolibre.NotNullTeam.DTO.response.buyer.BuyerResponseWithNotSellerListDTO;
import org.mercadolibre.NotNullTeam.DTO.response.post.PostsByFollowedDTO;
import org.mercadolibre.NotNullTeam.mapper.BuyerMapper;
import org.mercadolibre.NotNullTeam.mapper.PostMapper;
import org.mercadolibre.NotNullTeam.model.Buyer;
import org.mercadolibre.NotNullTeam.model.Post;
import org.mercadolibre.NotNullTeam.model.Seller;
import org.mercadolibre.NotNullTeam.model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GeneratorTest {
    private static Buyer buyer;
    private static Seller seller;

    static {
        buyer = Buyer.builder()
                .user(User.builder()
                        .id(3L)
                        .name("Buyer1")
                        .build()
                )
                .followedList(new ArrayList<>())
                .build();

        seller = Seller.builder()
                .user(User.builder()
                        .id(2L)
                        .name("Seller1")
                        .build()
                )
                .followersList(new ArrayList<>())
                .build();

        seller.setFollowersList(List.of(buyer));
        buyer.setFollowedList(List.of(seller));
    }

    public static Buyer getBuyer(){
        return buyer;
    }

    public static Seller getSeller(){
        return seller;
    }

    public static PostDTO getPostDTO() {
        return PostDTO.builder()
                .userId(2L)
                .date(LocalDate.now().minusDays(10).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")))
                .product(ProductDTO.builder()
                        .productId(1L)
                        .productName("Product1")
                        .type("Gamer")
                        .brand("Brand1")
                        .color("Color1")
                        .notes("Notes1")
                        .build()
                )
                .category(100)
                .price(100.0)
                .build();
    }

    public static PostsByFollowedDTO createPostsByFollowedDTO(PostDTO post) {
        User user = new User();
        user.setId(2L);

        seller = Seller.builder()
                .user(user
                )
                .build();

        Post postModel = PostMapper.postDtoToPost(post, seller);
        postModel.setId(postModel.getId() - 1);

        return PostMapper.postToPostByFollowed(3L, List.of(postModel));
    }

    public static List<BuyerResponseWithNotSellerListDTO> getBuyerResponseWithNotSellerListDTO() {
        return BuyerMapper.toListBuyerResponseWithNotSellerListDTO(List.of(buyer));
    }

}
