package bootcamp.sprint.grupo02.sprintI.util;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import bootcamp.sprint.grupo02.sprintI.dto.response.FollowedListResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.UserResponseDTO;
import bootcamp.sprint.grupo02.sprintI.model.Buyer;
import bootcamp.sprint.grupo02.sprintI.model.Post;
import bootcamp.sprint.grupo02.sprintI.model.Seller;

import java.util.ArrayList;
import java.util.Comparator;

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

    public static List<Post> createPostsBySellerId(int sellerId){
        LocalDate today = LocalDate.now();
        LocalDate lastWeek = today.minusWeeks(1);
        LocalDate twoWeeksAgo = today.minusWeeks(2);
        LocalDate threeWeeksAgo = today.minusWeeks(3);
        LocalDate nextWeek = today.plusWeeks(1);
        LocalDate[] dates = {today, lastWeek, twoWeeksAgo, threeWeeksAgo, nextWeek};
    
        return Arrays.asList(dates)
        .stream()
        .map(date -> Post.builder()
            .sellerId(sellerId)
            .date(date)
            .build()
        )
        .toList();
        
    }

    public static List<Buyer> get4FollowersAsc() {
        return List.of(
                createBuyerWithId(1),
                createBuyerWithId(2),
                createBuyerWithId(3),
                createBuyerWithId(4)
        );
    }
    public static List<Buyer> get4FollowersDesc() {
        return List.of(
                createBuyerWithId(4),
                createBuyerWithId(3),
                createBuyerWithId(2),
                createBuyerWithId(1)
        );
    }
    public static List<Seller> get4FollowedAsc() {
        return List.of(
                createSellerWithId(1),
                createSellerWithId(2),
                createSellerWithId(3),
                createSellerWithId(4)
        );
    }
    public static List<Seller> get4FollowedDesc() {
        return List.of(
                createSellerWithId(4),
                createSellerWithId(3),
                createSellerWithId(2),
                createSellerWithId(1)
        );
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
}
