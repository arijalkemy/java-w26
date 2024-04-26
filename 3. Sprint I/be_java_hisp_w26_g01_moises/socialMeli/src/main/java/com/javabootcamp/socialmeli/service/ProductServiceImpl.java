package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.LastPostDto;
import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.enums.OrderType;
import com.javabootcamp.socialmeli.exception.EntityNotFoundException;
import com.javabootcamp.socialmeli.exception.IllegalActionException;
import com.javabootcamp.socialmeli.model.Product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final PostService postService;
    private final UserService userService;

    @Override
    public Product addProduct(Product product) {
        return null;
    }

     @Override
    public LastPostDto getPostFromLastTwooWeeksOrder(Integer userId, OrderType order) {
        //busco la lista de id de los vendedores seguidos

         if(order.equals(OrderType.name_asc) || order.equals(OrderType.name_desc)){
             throw new IllegalActionException("Invalid order type.");
         }

        List<Integer> sellerList=userService.getListSellerId(userId);


        List<PostDto> postsDto;
        //busco los posteos de las últimas dos semanas

        if(order.equals(OrderType.date_asc)){
            postsDto = postService.findByTwoWeeksAgoOrderAsc( sellerList);
        }
        else{
            postsDto = postService.findByTwoWeeksAgoOrderDesc(sellerList);
        }

        if(postsDto.isEmpty()){
            throw new EntityNotFoundException("There are no posts from followed sellers.");
        }
        return new LastPostDto(userId,postsDto);
    }

    @Override
    public LastPostDto getPostFromLastTwoWeeks(Integer userId) {
        //busco la lista de id de los vendedores seguidos
        List<Integer> sellerList=userService.getListSellerId(userId);
        //busco los posteos de las últimas dos semanas
        List<PostDto> postsDto= postService.findByTwoWeeksAgo( sellerList);
        if(postsDto.isEmpty()){
            throw new EntityNotFoundException("There are no posts from followed sellers.");
        }
        return new LastPostDto(userId,postsDto);
    }

}
