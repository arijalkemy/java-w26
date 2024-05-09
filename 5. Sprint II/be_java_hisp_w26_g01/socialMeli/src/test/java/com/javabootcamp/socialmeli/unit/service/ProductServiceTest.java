package com.javabootcamp.socialmeli.unit.service;

import com.javabootcamp.socialmeli.dto.request.PostDto;
import com.javabootcamp.socialmeli.enums.OrderType;
import com.javabootcamp.socialmeli.exception.IllegalActionException;
import com.javabootcamp.socialmeli.service.PostService;
import com.javabootcamp.socialmeli.service.ProductServiceImpl;
import com.javabootcamp.socialmeli.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private PostService postService;

    @Mock
    private UserService userService;

    @InjectMocks
    private ProductServiceImpl productService;

    //T-0005 -> Se cumple
    @Test
    @DisplayName("T-0005 -> Verifica si el tipo de ordenamiento por fecha existe y existe")
    public void verifyDateOrderTypeExists(){

        int idUser = 1;
        List<Integer> listIdSeller = new ArrayList<>();
        List<PostDto> postDtos = new ArrayList<>(List.of(new PostDto()));


        Mockito.when(userService.getListSellerId(idUser)).thenReturn(listIdSeller);
        Mockito.when(postService.findByTwoWeeksAgoOrderAsc(listIdSeller)).thenReturn(postDtos);

        productService.getPostFromLastTwooWeeksOrder(1, OrderType.date_asc);


        Mockito.verify((postService), Mockito.atLeastOnce()).findByTwoWeeksAgoOrderAsc(listIdSeller);

    }


    //T-0005 -> No se cumple
    @DisplayName("T-0005 -> Verifica si el tipo de ordenamiento por fecha existe y falla")
    @Test
    public void verifyDateOrderTypeDoesNotExists(){

        Assertions.assertThrows(IllegalActionException.class,
                        ()-> productService.getPostFromLastTwooWeeksOrder(1, OrderType.name_asc));
    }

}
