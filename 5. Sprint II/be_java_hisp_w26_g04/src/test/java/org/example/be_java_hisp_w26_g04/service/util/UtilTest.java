package org.example.be_java_hisp_w26_g04.service.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.example.be_java_hisp_w26_g04.dto.BuyerDTO;
import org.example.be_java_hisp_w26_g04.dto.PostResponseDTO;
import org.example.be_java_hisp_w26_g04.dto.ProductDTO;
import org.example.be_java_hisp_w26_g04.dto.SellerFollowersDTO;
import org.example.be_java_hisp_w26_g04.dto.UserDTO;
import org.example.be_java_hisp_w26_g04.model.Buyer;
import org.example.be_java_hisp_w26_g04.model.Post;
import org.example.be_java_hisp_w26_g04.model.Seller;
import org.example.be_java_hisp_w26_g04.util.mapper.CustomMapper;
import org.junit.jupiter.api.Assertions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class UtilTest {

    public static Set<Buyer> getBuyers() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource("data/buyer.json");
        return objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {
        });
    }

    public static Set<Seller> getSellers() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        Resource resource = new ClassPathResource("data/seller.json");

        return objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {
        });
    }

    public static List<PostResponseDTO> generatePostResponseDTOAsc() {
        ProductDTO productDTO1 = getProduct2();
        ProductDTO productDTO2 = getProduct4();

        PostResponseDTO post1 = PostResponseDTO.builder()
            .idPost(2)
            .userId(123)
            .date(LocalDate.of(2024, 5, 8))
            .category(2)
            .price(75.0)
            .product(productDTO1)
            .build();

        PostResponseDTO post2 = PostResponseDTO.builder()
            .idPost(5)
            .userId(234)
            .date(LocalDate.of(2024, 5, 28))
            .category(2)
            .price(65.0)
            .product(productDTO2)
            .build();

        return List.of(post1, post2);
    }

    // TODO: Preguntar a Eze si es correcto generar la lista usando el otro método
    //  o si debemos duplicar ese código
    public static List<PostResponseDTO> generatePostResponseDTODesc() {
        List<PostResponseDTO> responses = new ArrayList<>(generatePostResponseDTOAsc());
        Collections.reverse(responses);
        return responses;
    }

    public static ProductDTO getProduct2() {
        return ProductDTO.builder()
            .productId(2)
            .productName("Product2")
            .typeProduct("TypeB")
            .brand("BrandY")
            .color("Red")
            .notes("Some notes about Product2")
            .build();
    }

    public static ProductDTO getProduct4() {
        return ProductDTO.builder()
            .productId(4)
            .productName("Product4")
            .typeProduct("TypeD")
            .brand("BrandW")
            .color("Yellow")
            .notes("Some notes about Product4")
            .build();
    }

    public static SellerFollowersDTO generateListFollowersAsc() {
        List<UserDTO> userDTOList = getFollowersDto();
        return new SellerFollowersDTO(234, "JaneSmith", userDTOList);
    }

    public static SellerFollowersDTO generateListFollowersDesc() {
        List<UserDTO> userDTOList = new ArrayList<>(getFollowersDto());
        Collections.reverse(userDTOList);
        return new SellerFollowersDTO(234, "JaneSmith", userDTOList);
    }

    private static List<UserDTO> getFollowersDto() {
        List<UserDTO> userDTOList = new ArrayList<>();
        userDTOList.add(new UserDTO(789, "AliceSmith"));
        userDTOList.add(new UserDTO(456, "JaneDoe"));
        return userDTOList;
    }

    public static BuyerDTO generateListFollowedAsc() {
        List<UserDTO> userDTOList = getFollowedDtos();
        return new BuyerDTO(456, "JaneDoe", userDTOList);
    }

    public static BuyerDTO generateListFollowedDesc() {
        List<UserDTO> userDTOList = getFollowedDtos();
        Collections.reverse(userDTOList);
        return new BuyerDTO(456, "JaneDoe", userDTOList);
    }

    private static List<UserDTO> getFollowedDtos() {
        List<UserDTO> userDTOList = new ArrayList<>();
        userDTOList.add(new UserDTO(234, "JaneSmith"));
        userDTOList.add(new UserDTO(123, "JohnDoe"));
        return userDTOList;
    }

    public static <T> void assertEqualsDtoAsString(T expected, T result
    ) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper().registerModule(new JavaTimeModule());
        Assertions.assertEquals(om.writeValueAsString(expected), om.writeValueAsString(result));
    }

    public static List<PostResponseDTO> mapListPostToPostResponseDto(List<Post> posts) {
        return posts.stream().map(p -> CustomMapper.mapper(p, PostResponseDTO.class)).toList();
    }

    public static Post todayPost() {
        return createPostOfDate(1, LocalDate.now());
    }

    public static Post weekAgoPost() {
        return createPostOfDate(2, LocalDate.now().minusWeeks(1));
    }

    public static Post twoWeeksAgoPost() {
        return createPostOfDate(3, LocalDate.now().minusWeeks(2));
    }

    public static Post createPostOfDate(int postId, LocalDate date) {
        return new Post(postId, 1, date, null, 0, 0);
    }
}
