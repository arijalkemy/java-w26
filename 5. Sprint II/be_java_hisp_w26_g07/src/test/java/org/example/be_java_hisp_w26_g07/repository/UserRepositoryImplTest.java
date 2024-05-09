package org.example.be_java_hisp_w26_g07.repository;

import org.example.be_java_hisp_w26_g07.entity.Post;
import org.example.be_java_hisp_w26_g07.entity.User;
import org.example.be_java_hisp_w26_g07.utils.GeneratorDataTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
class UserRepositoryImplTest {
    private UserRepositoryImpl userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepositoryImpl(GeneratorDataTest.findUsers());
    }

    @Test
    @DisplayName("T-0001: El usuario esta siguiendo al vendedor")
    void userFollowSellerTest() {
        // Given - Arrange
        // When - Act
        boolean alreadyFollows = userRepository.userFollowSeller(1, 2);
        boolean isNotFollowing = userRepository.userFollowSeller(7, 7);
        // Then - Assert
        Assertions.assertTrue(alreadyFollows);
        Assertions.assertFalse(isNotFollowing);
    }

    @Test
    @DisplayName("T-0001: Agregar follow")
    void addFollowerByIdTest() {
        // Given - Arrange
        // When - Act
        boolean followAdded = userRepository.addFollowerById(8, 5);
        // Then - Assert
        Assertions.assertTrue(followAdded);
    }

    @Test
    @DisplayName("T-0002: Dejar de seguir un usuario: correctamente")
    void repositoryUnfollow() {
        // Arrange
        Boolean expected = true;
        List<User> users = GeneratorDataTest.usersById(1, 2);

        // Act
        Boolean actual = userRepository.unfollow(users.get(0), users.get(1));

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T-0002: Dejar de seguir un usuario: usuario no sigue cliente")
    void repositoryUnfollowFailed() {
        // Arrange
        Boolean expected = false;
        List<User> users = GeneratorDataTest.usersById(1, 5);

        // Act
        Boolean actual = userRepository.unfollow(users.get(0), users.get(1));

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Encuentra usuario por su id y lo retorna correctamente")
    void findByIdTest() {
        //Arrange
        User expected = GeneratorDataTest.findUsers().get(0);

        //Act
        User output = userRepository.findById(1);

        //Assert
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Busca un usuario por id pero no existe y retorna null")
    void findByIdNullTest() {
        //Act
        User output = userRepository.findById(20);

        //Assert
        assertNull(output);
    }

    @Test
    @DisplayName("T-0006: lista vacia porque usuario no tiene posts")
    void findProductByFollowEmpty() {
        // Given - Arrange
        User seller = userRepository.findById(10);
        // When - Act
        List<Post> resPosts = userRepository.findProductByFollow(seller);
        // Then - Assert
        org.assertj.core.api.Assertions.assertThat(resPosts).isEmpty();
    }

    @Test
    @DisplayName("T-0006: lista con posts del usuario")
    void findProductByFollowFilled() {
        // Given - Arrange
        User seller = userRepository.findById(5);
        // When - Act
        List<Post> resPosts = userRepository.findProductByFollow(seller);
        // Then - Assert
        org.assertj.core.api.Assertions.assertThat(resPosts).hasSize(2);
    }
}
