package org.example.be_java_hisp_w26_g07.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.be_java_hisp_w26_g07.dto.products.PostDto;
import org.example.be_java_hisp_w26_g07.dto.products.PostRequestDto;
import org.example.be_java_hisp_w26_g07.entity.Post;
import org.example.be_java_hisp_w26_g07.entity.User;
import org.example.be_java_hisp_w26_g07.exception.BadRequestException;
import org.example.be_java_hisp_w26_g07.exception.NotFoundException;
import org.example.be_java_hisp_w26_g07.repository.interfaces.IUserRepository;
import org.example.be_java_hisp_w26_g07.service.interfaces.IProductService;
import org.example.be_java_hisp_w26_g07.utils.PostUtil;
import org.example.be_java_hisp_w26_g07.utils.UserMessageError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements IProductService {

    private final IUserRepository iUserRepository;

    public ProductImpl(@Autowired IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    /**
     * US 0005
     * Servicio: Dar de alta una nueva publicación
     *
     * @param postRequestDto PostRequestDto
     */
    @Override
    public PostDto createPost(PostRequestDto postRequestDto) {
        User myUser = iUserRepository.findById(postRequestDto.getUserId());
        if (myUser == null) {
            throw new BadRequestException(UserMessageError.USER_NOT_FOUND.getMessage(postRequestDto.getUserId()));
        }
        ObjectMapper mapper = new ObjectMapper();
        Post post = mapper.convertValue(postRequestDto, Post.class);
        post.setId(PostUtil.increaseCounter());
        myUser.getPosts().add(post);
        myUser.setIsSeller(true);
        return mapper.convertValue(post, PostDto.class);
    }

    /**
     * US 0006
     * servicio: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las
     * últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
     *
     * @param userID PostRequestDto
     * @param order  Tipo de orden (opcional)
     */
    @Override
    public List<PostDto> findProductByFollow(Integer userID, String order) {
        ObjectMapper mapper = new ObjectMapper();
        if (!PostUtil.orderValidation(order)) {
            throw new BadRequestException(UserMessageError.LIST_CLIENTE_ORDER.getMessage());
        }
        User user = iUserRepository.findById(userID);
        if (user == null) {
            throw new NotFoundException(UserMessageError.USER_NOT_FOUND.getMessage(userID));
        }
        List<Post> postsList = iUserRepository.findProductByFollow(user);
        if (postsList.isEmpty()) {
            throw new NotFoundException("No se encontraron publicaciones para las ultimas dos semanas.");
        }
        return PostUtil.getPostOrderByDate(postsList, order).stream()
                .map(post -> mapper.convertValue(post, PostDto.class)).toList();
    }
}
