package com.meli.be_java_hisp_w26_g09.util.mapper;

import com.meli.be_java_hisp_w26_g09.dto.PostDTO;
import com.meli.be_java_hisp_w26_g09.dto.PostForListDTO;
import com.meli.be_java_hisp_w26_g09.dto.ProductDTO;
import com.meli.be_java_hisp_w26_g09.entity.Post;
import com.meli.be_java_hisp_w26_g09.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostMapperTest {
    private PostMapper postMapper;

    @BeforeEach
    void setUp() {
        postMapper = new PostMapper();
    }

    @Test
    @DisplayName("Test postDTOtoPost converts correctly")
    void postDTOtoPost_ConvertsCorrectly() {
        PostDTO postDTO = PostDTO.builder().userId(1).date(formattedDate(2024, 4, 4))
                .product(ProductDTO.builder()
                        .productId(40)
                        .productName("HyperX Cloud II Gaming Headset")
                        .type("Headset")
                        .brand("HyperX")
                        .color("Red")
                        .notes("7.1 Virtual Surround Sound, Detachable noise-canceling microphone")
                        .build())
                .category(2)
                .price(99.99)
                .build();

        Post result = postMapper.postDTOtoPost(postDTO);

        assertEquals(postDTO.getUserId(), result.getUserId());
        assertEquals(postDTO.getDate(), result.getDate());
        assertEquals(postDTO.getCategory(), result.getCategory());
        assertEquals(postDTO.getPrice(), result.getPrice());
        assertEquals(postDTO.getHasPromo(), result.getHasPromo());
        assertEquals(postDTO.getDiscount(), result.getDiscount());
        ProductDTO productDTO = postDTO.getProduct();
        Product product = result.getProduct();
        assertEquals(productDTO.getProductId(), product.getProductId());
        assertEquals(productDTO.getProductName(), product.getProductName());
        assertEquals(productDTO.getType(), product.getType());
        assertEquals(productDTO.getBrand(), product.getBrand());
        assertEquals(productDTO.getColor(), product.getColor());
        assertEquals(productDTO.getNotes(), product.getNotes());
    }

    private LocalDate formattedDate(int year, int month, int day){
        LocalDate date = LocalDate.of(year, month, day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = date.format(formatter);
        return LocalDate.parse(formattedDate, formatter);
    }

    @Test
    @DisplayName("Test postListToPostForListDTOS converts correctly")
    void postListToPostForListDTOS_ConvertsCorrectly() {
        List<Post> posts = new ArrayList<>();
        Product product1 = new Product(1, "Product1", "Type1", "Brand1", "Color1", "Notes1");
        Product product2 = new Product(2, "Product2", "Type2", "Brand2", "Color2", "Notes2");
        Post post1 = new Post(1, 1, LocalDate.now(), product1, 1, 100.0, true, 0.1);
        Post post2 = new Post(2, 2, LocalDate.now(), product2, 2, 200.0, false, 0.0);
        posts.add(post1);
        posts.add(post2);

        List<PostForListDTO> result = postMapper.postListToPostForListDTOS(posts);

        assertEquals(posts.size(), result.size());
        for (int i = 0; i < posts.size(); i++) {
            Post post = posts.get(i);
            PostForListDTO postForListDTO = result.get(i);
            assertEquals(post.getUserId(), postForListDTO.getUserId());
            assertEquals(post.getId(), postForListDTO.getPostId());
            assertEquals(post.getDate(), postForListDTO.getDate());
            assertEquals(post.getCategory(), postForListDTO.getCategory());
            assertEquals(post.getPrice(), postForListDTO.getPrice());
            assertEquals(post.getProduct().getProductId(), postForListDTO.getProduct().getProductId());
            assertEquals(post.getProduct().getProductName(), postForListDTO.getProduct().getProductName());
            assertEquals(post.getProduct().getType(), postForListDTO.getProduct().getType());
            assertEquals(post.getProduct().getBrand(), postForListDTO.getProduct().getBrand());
            assertEquals(post.getProduct().getColor(), postForListDTO.getProduct().getColor());
            assertEquals(post.getProduct().getNotes(), postForListDTO.getProduct().getNotes());
        }
    }
}