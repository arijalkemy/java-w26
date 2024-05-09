package bootcamp.sprint.grupo02.sprintI.util;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import bootcamp.sprint.grupo02.sprintI.dto.request.PostDTO;
import bootcamp.sprint.grupo02.sprintI.dto.request.ProductDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.FollowedListResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.FollowersListResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.PostListByBuyerResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.PostResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.ProductResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.UserResponseDTO;
import bootcamp.sprint.grupo02.sprintI.model.Buyer;
import bootcamp.sprint.grupo02.sprintI.model.Post;
import bootcamp.sprint.grupo02.sprintI.model.Product;
import bootcamp.sprint.grupo02.sprintI.model.Seller;

import java.util.ArrayList;

public class TestGeneratorUtil {

    public static Seller createSellerWithId(int id) {
        return Seller.builder()
                .id(id)
                .name(String.format("Seller %d", id))
                .followers(new ArrayList<>())
                .build();
    }

    public static Buyer createBuyerWithId(int id) {
        return Buyer.builder()
                .id(id)
                .name(String.format("Buyer %d", id))
                .follows(new ArrayList<>())
                .build();
    }

    public static Buyer createBuyerWithIdAndFollows(int id) {
        List<Seller> follows = new ArrayList<Seller>();
        follows.add(createSellerWithId(2));
        follows.add(createSellerWithId(3));

        return Buyer.builder()
                .id(id)
                .name(String.format("Buyer %d", id))
                .follows(follows)
                .build();
    }

    public static Seller createSellerWithIdAndFollowers(int id) {
        List<Buyer> followers = new ArrayList<Buyer>();
        followers.add(createBuyerWithId(2));
        followers.add(createBuyerWithId(3));

        return Seller.builder()
                .id(id)
                .name(String.format("Buyer %d", id))
                .followers(followers)
                .build();
    }

    public static List<Seller> createSellers() {
        return List.of(createSellerWithId(1), createSellerWithId(2));
    }

    public static List<Integer> createSellersIdList() {
        return List.of(1, 2);
    }

    public static List<Post> createPostsBySellerId(int sellerId) {
        LocalDate today = LocalDate.now();
        LocalDate lastWeek = today.minusWeeks(1);
        LocalDate twoWeeksAgo = today.minusWeeks(2);
        LocalDate threeWeeksAgo = today.minusWeeks(3);
        LocalDate nextWeek = today.plusWeeks(1);
        LocalDate[] dates = { today, lastWeek, twoWeeksAgo, threeWeeksAgo, nextWeek };

        return Arrays.asList(dates)
                .stream()
                .map(date -> Post.builder()
                        .sellerId(sellerId)
                        .date(date)
                        .build())
                .toList();

    }

    public static List<Buyer> get4FollowersAsc() {
        return List.of(
                createBuyerWithId(1),
                createBuyerWithId(2),
                createBuyerWithId(3),
                createBuyerWithId(4));
    }

    public static List<Buyer> get4FollowersDesc() {
        return List.of(
                createBuyerWithId(4),
                createBuyerWithId(3),
                createBuyerWithId(2),
                createBuyerWithId(1));
    }

    public static List<Seller> get4FollowedAsc() {
        return List.of(
                createSellerWithId(1),
                createSellerWithId(2),
                createSellerWithId(3),
                createSellerWithId(4));
    }

    public static List<Seller> get4FollowedDesc() {
        return List.of(
                createSellerWithId(4),
                createSellerWithId(3),
                createSellerWithId(2),
                createSellerWithId(1));
    }

    public static Seller createSellerWithFollowers(int id) {
        return Seller.builder()
                .id(id)
                .name(String.format("Seller %d", id))
                .followers(get4FollowersAsc())
                .build();
    }

    public static Buyer createBuyerWithFollowed(int id) {
        return Buyer.builder()
                .id(id)
                .name(String.format("Buyer %d", id))
                .follows(get4FollowedAsc())
                .build();
    }

    public static ProductDTO createProductDTOWithId(int id) {
        return ProductDTO.builder()
                .productId(id)
                .productName(String.format("Product %s", id))
                .brand(String.format("Brand %s", id))
                .type(String.format("Type %s", id))
                .color(String.format("Colors %s", id))
                .notes(String.format("Notes %s", id))
                .build();
    }

    public static Product createProductithId(int id) {
        return Product.builder()
                .id(id)
                .name(String.format("Product %s", id))
                .brand(String.format("Brand %s", id))
                .type(String.format("Type %s", id))
                .color(String.format("Colors %s", id))
                .notes(String.format("Notes %s", id))
                .build();
    }

    public static ProductResponseDTO creaProductResponseDTOWithId(int id) {
        return ProductResponseDTO.builder()
                .id(id)
                .name(String.format("Product %s", id))
                .brand(String.format("Brand %s", id))
                .type(String.format("Type %s", id))
                .color(String.format("Colors %s", id))
                .notes(String.format("Notes %s", id))
                .build();
    }

    public static PostDTO createPostDtoWithId(int id) {

        return PostDTO.builder()
                .userId(id)
                .price(1.0)
                .category(1)
                .date("19-10-2024")
                .product(createProductDTOWithId(1))
                .build();
    }

    public static PostListByBuyerResponseDTO createPostListByBuyerResponseDTO() {
        List<PostResponseDTO> postResponseDTOList = new ArrayList<PostResponseDTO>();

        ProductResponseDTO productResponseDTO = ProductResponseDTO
                .builder()
                .id(2)
                .name("Termo2")
                .type("Tipo 2")
                .brand("Lumilagro")
                .color("gris")
                .notes("Bueno, bonito y barato")
                .build();

        ProductResponseDTO productResponseDTO1 = ProductResponseDTO
                .builder()
                .id(1)
                .name("Termo")
                .type("Tipo 1")
                .brand("Stanley")
                .color("Verde")
                .notes("Muy caro para lo que es")
                .build();

        postResponseDTOList.add(
                PostResponseDTO
                        .builder()
                        .userId(1)
                        .postId(2)
                        .category(1)
                        .date(LocalDate.of(2024, Month.APRIL, 30))
                        .price(2000)
                        .product(productResponseDTO)
                        .build()
        );

        postResponseDTOList.add(
                PostResponseDTO
                        .builder()
                        .userId(1)
                        .postId(1)
                        .category(1)
                        .date(LocalDate.of(2024, Month.MAY, 8))
                        .price(100)
                        .product(productResponseDTO1)
                        .build()
        );

        return PostListByBuyerResponseDTO
                .builder()
                .userId(1)
                .posts(postResponseDTOList)
                .build();
    }


    public static FollowersListResponseDTO createFollowersListResponseDTO() {
        UserResponseDTO owner = new UserResponseDTO(1, "Un Vendedor");
        List<UserResponseDTO> followers = new ArrayList<>(List.of(new UserResponseDTO(1, "Seguidor 1"), 
        new UserResponseDTO(2, "Seguidor 2"),
        new UserResponseDTO(3, "Seguidor 3")));
        return new FollowersListResponseDTO(owner, followers);
    }   

    public static FollowedListResponseDTO createFollowedListResponseDTO() {
        UserResponseDTO owner = new UserResponseDTO(1, "Comprador");
        List<UserResponseDTO> followers = new ArrayList<>(List.of(new UserResponseDTO(1, "Un Vendedor"), 
        new UserResponseDTO(2, "Un Vendedor 2")));
        return new FollowedListResponseDTO(owner, followers);
    }   
}
