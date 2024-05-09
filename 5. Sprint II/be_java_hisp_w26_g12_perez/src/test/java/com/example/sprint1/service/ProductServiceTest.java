package com.example.sprint1.service;

import com.example.sprint1.dto.PostDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    ProductServiceImpl productService;

    @Test
    public void testPostMethods() {
        // arrange
        PostDto postDto = new PostDto();
        Integer userId = 1;
        String order = "order";
        // act
        Object result = productService.addPost(postDto);
        Object result2 = productService.followedList(userId, order);
        Object result3 = productService.followedList(userId);
        Object result4 = productService.postPromo(postDto);
        Object result5 = productService.quantityPromo(userId);
        Object result6 = productService.getPromo(userId);

        // assert
        Assertions.assertNull(result);
        Assertions.assertNull(result2);
        Assertions.assertNull(result3);
        Assertions.assertNull(result4);
        Assertions.assertNull(result5);
        Assertions.assertNull(result6);

    }
}
