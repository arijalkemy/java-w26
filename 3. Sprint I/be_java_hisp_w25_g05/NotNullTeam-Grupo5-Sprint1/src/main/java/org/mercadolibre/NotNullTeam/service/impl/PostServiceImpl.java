package org.mercadolibre.NotNullTeam.service.impl;

import lombok.RequiredArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.ProductDTO;
import org.mercadolibre.NotNullTeam.DTO.response.PostResponseDTO;
import org.mercadolibre.NotNullTeam.DTO.response.PostsByFollowedDTO;
import org.mercadolibre.NotNullTeam.exception.error.NotFoundException;
import org.mercadolibre.NotNullTeam.model.Buyer;
import org.mercadolibre.NotNullTeam.model.Post;
import org.mercadolibre.NotNullTeam.model.Product;
import org.mercadolibre.NotNullTeam.model.Seller;
import org.mercadolibre.NotNullTeam.repository.IBuyerRepository;
import org.mercadolibre.NotNullTeam.repository.IPostRepository;
import org.mercadolibre.NotNullTeam.repository.ISellerRepository;
import org.mercadolibre.NotNullTeam.service.IPostService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements IPostService {
    final IPostRepository iPostRepository;
    final ISellerRepository iSellerRepository;
    final IBuyerRepository iBuyerRepository;

    @Override
    public void createPost(PostDTO postDTO) {
        iPostRepository.createPost(postDtoToPost(postDTO));
    }

    private Post postDtoToPost(PostDTO postDTO) {
        return new Post(findSellerById(postDTO.getUser_id()),
                LocalDate.parse(postDTO.getDate(),
                        DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                productDtoToProduct(postDTO.getProduct()),
                postDTO.getCategory(),
                postDTO.getPrice());
    }

    private Seller findSellerById(Long id){
        return iSellerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Seller"));
    }

    private Product productDtoToProduct(ProductDTO productDTO) {
        return new Product(productDTO.getProduct_id(),
                productDTO.getProduct_name(),
                productDTO.getType(),
                productDTO.getBrand(),
                productDTO.getColor(),
                productDTO.getNotes());
    }

    @Override
    public PostsByFollowedDTO getPostsBySellerTwoWeeksAgo(Long userId, String order) {
        List<Post> posts = new ArrayList<>();

        iBuyerRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Buyer"))
                .getFollowedList().stream()
                .map(post -> iPostRepository.getPostsBySellerIdTwoWeeksAgo(post.getUser().getId()))
                .forEach(posts::addAll);

        if(order.equals("date_asc")) {
            posts.sort(Comparator.comparing(Post::getDate));
        }else{
            posts.sort(Comparator.comparing(Post::getDate).reversed());
        }

        return postToPostByFollowed(userId, posts);
    }

    private PostsByFollowedDTO postToPostByFollowed(Long id, List<Post> posts){
        return new PostsByFollowedDTO(id, posts.stream()
                                            .map(this::postToPostResponseDto)
                                            .toList());
    }

    private PostResponseDTO postToPostResponseDto(Post post) {
        return new PostResponseDTO(post.getSeller().getUser().getId(),
                post.getId(),
                post.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                productToProductDto(post.getProduct()),
                post.getCategory(),
                post.getPrice());
    }

    private ProductDTO productToProductDto(Product product) {
        return new ProductDTO(product.getId(),
                product.getName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes());
    }
}
