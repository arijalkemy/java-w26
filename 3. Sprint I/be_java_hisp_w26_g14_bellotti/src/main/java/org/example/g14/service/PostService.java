package org.example.g14.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.g14.dto.CreatePostDto;
import org.example.g14.dto.PostDto;
import org.example.g14.dto.ProductDto;
import org.example.g14.dto.UserWithPostPromoCount;
import org.example.g14.exception.BadRequestException;
import org.example.g14.exception.ConflictException;
import org.example.g14.exception.NotFoundException;
import org.example.g14.model.Post;
import org.example.g14.model.User;
import org.example.g14.repository.IPostRepository;
import org.example.g14.repository.IUserRepository;
import org.example.g14.utils.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {
    @Autowired
    IPostRepository postRepository;

    @Autowired
    IUserRepository userRepository;

    @Override
    public void add(CreatePostDto createPostDto) {
        PostMapper postMapper = new PostMapper();
        Post post = postMapper.createPostDtoToPost(createPostDto);

        getById(createPostDto.getIdUser());

        postRepository.save(post);
    }

    //10
    @Override
    public void addWithPromo(CreatePostDto createPostDto) {
        if(!createPostDto.isHasPromo())
            throw new BadRequestException("El producto debe estar en promocion");

        if(createPostDto.getDiscount()<=0)
            throw new BadRequestException("El producto debe tener un valor mayor a cero en el descuento");

        add(createPostDto);
    }


    @Override
    public List<PostDto> getPostsFromFollowed(int userId, String order) {
        User user = userRepository.getById(userId).orElseThrow(() -> new NotFoundException("Usuario no encontrado"));

        List<Integer> followedVendors = user.getIdFollows();

        List<Post> allPosts = new ArrayList<>();
        for (Integer vendorId : followedVendors) {
            allPosts.addAll(postRepository.findAllByUser(vendorId));
        }

        if (order != null && !order.isEmpty() && !order.equals("date_asc") && !order.equals("date_desc")) {
            throw new BadRequestException("Tipo de orden inválido");
        }

        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);
        List<Post> recentPosts = new ArrayList<>(allPosts.stream()
                .filter(post -> post.getDate().isAfter(twoWeeksAgo))
                .toList());

        if (order != null && order.equals("date_asc")) {
            recentPosts.sort(Comparator.comparing(Post::getDate));
        } else if (order != null && order.equals("date_desc")) {
            recentPosts.sort(Comparator.comparing(Post::getDate).reversed());
        }

        return recentPosts.stream()
                .map(post -> {

                    ProductDto productDto = new ProductDto();
                    productDto.setId(post.getProduct().getId());
                    productDto.setName(post.getProduct().getName());
                    productDto.setType(post.getProduct().getType());
                    productDto.setBrand(post.getProduct().getBrand());
                    productDto.setColor(post.getProduct().getColor());
                    productDto.setNotes(post.getProduct().getNotes());

                    return new PostDto(
                            post.getIdUser(),
                            post.getId(),
                            post.getDate(),
                            productDto,
                            post.getCategory(),
                            post.getPrice()
                    );
                })
                .collect(Collectors.toList());
    }

    //11
    @Override
    public UserWithPostPromoCount getCountOfPromo(int userId) {
        User user = getById(userId);

        return new UserWithPostPromoCount(
                user.getId(),
                user.getName(),
                (int)getPostAndValidateSeller(userId)
                        .stream()
                        .filter(p->p.isHasPromo())
                        .count()
        );
    }

    @Override
    public PostDto putToPromo(int userId, int postId) {
        getById(userId);

        Post post = getPostAndValidateSeller(userId).stream()
                .filter(p->p.getId() == postId)
                .findFirst()
                .orElse(null);

        if(post == null)
            throw new BadRequestException("No es una publicacion tuya");

        if(post.isHasPromo())
            throw new ConflictException("La publicacion ya se encuentra en promocion");

        post.setHasPromo(true);
        postRepository.save(post);

        return new PostMapper().createPostToPostDto(post);
    }

    private User getById(int idUser){
        Optional<User> user = userRepository.getById(idUser);

        if(user.isEmpty())
            throw new NotFoundException("El usuario no existe");

        return user.get();
    }

    private List<Post> getPostAndValidateSeller(int userId){
        List<Post> posts = postRepository.findAllByUser(userId);
        if(posts.size()==0)
            throw new BadRequestException("No sos usuario vendedor");

        return posts;
    }
}
