package com.meli.be_java_hisp_w26_g10.repository;

import com.api.socialmeli.entity.Buyer;
import com.api.socialmeli.entity.Post;
import com.api.socialmeli.entity.Product;
import com.api.socialmeli.entity.Seller;
import com.api.socialmeli.repository.impl.PostRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

public class PostRepositoryTest {

    PostRepositoryImpl postRepository = new PostRepositoryImpl();

    @Test
    @DisplayName("T000G - Obtener un post que existe ")
    public void getAnExistingPostTest(){
        //Act && Arrange
        Post postObtained = postRepository.getById(1);
        //Assert
        Assertions.assertNotNull(postObtained);
    }

    @Test
    @DisplayName("T000G - Obtener un post que no existe ")
    public void getANonExistingPostTest(){
        //Act && Arrange
        Post postObtained = postRepository.getById(100);
        //Assert
        Assertions.assertNull(postObtained);
    }

    @Test
    @DisplayName("T000G - Obtener todos los post")
    public void getAllPostsTest(){
        //Act && Arrange
        List<Post> posts = postRepository.getAll();
        //Assert
        Assertions.assertEquals(posts.size(), 20);
    }

    @Test
    @DisplayName("T000G - Obtener Id para generar Id consecutivo")
    public void searchIdPostTest(){
        //Act && Arrange
        int id = postRepository.searchPostId();
        //Assert
        Assertions.assertEquals(id, 21);
    }

    @Test
    @DisplayName("T000G - Guardar un Post")
    public void savePostTest(){
        //Act && Arrange
        Product product = new Product(20, "Tenis", "Nike", "Runner", "Gris", "");
        Post post = new Post(40, LocalDate.now(),2,10.000,1, product,false,0.0);
        //Assert
        postRepository.savePost(post);
        List<Post> postList = postRepository.getAll();
        Assertions.assertTrue(postList.contains(post));
    }

}
