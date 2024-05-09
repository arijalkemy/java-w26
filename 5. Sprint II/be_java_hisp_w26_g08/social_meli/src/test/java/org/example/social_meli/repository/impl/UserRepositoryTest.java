package org.example.social_meli.repository.impl;
import org.example.social_meli.model.FollowerList;
import org.example.social_meli.model.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {

    private List<User> userList;

    private UserRepository userRepository;
    private FollowerList followerList;
    private User user;

    @BeforeEach
    void setUp() throws IOException {
        userRepository = new UserRepository();
        user = new User(1, "user", false);
        followerList = new FollowerList(user);

        User user1 = new User(2, "User1", true);
        User user2 = new User(1,"User2",false);
        List <User> users =new ArrayList<>();
        users.add(user1);
        users.add(user2);
    }
    @Test
    @DisplayName("Verificar método findByID, usuario existe.")
    void findById_UserExist() {
        //Arrange
        Integer userId = 1;
        //Act
        User found = userRepository.findById(userId);
        //Assert
        assertEquals(userId, found.getUserId(), "El ID del usuario encontrado debe coincidir con el buscado.");
        assertNotNull(found, "El usuario encontrado no debe ser nulo.");
    }
    @Test
    @DisplayName("Verificar método findByID, usuario no existe.")
    void findById_UserNoExist() {
        //Arrange
        Integer userId = 99999;
        //Act
        User found = userRepository.findById(userId);
        //Assert
        assertNull(found, "Debe devolver null si el usuario no existe.");
    }
    @Test
    @DisplayName("Veficar método exixtByID, usuario existente.")
    void existById_UserExits(){
        //Arrange
        Integer userId = 1;
        //Act
        Boolean exists = userRepository.existsById(userId);
        //Assert
        assertTrue(exists, "El método debería retornar verdadero para un usuario existente");
    }
    @Test
    @DisplayName("Veficar método exixtByID, usuario no existente.")
    void existById_UserNoExits(){
        //Arrange
        Integer userId = 588;
        //Act
        Boolean exists = userRepository.existsById(userId);
        //Assert
        assertFalse(exists, "El método debería retornar falso para un usuario existente");
    }
    @Test
    @DisplayName("Deberia retornar el indice del cliente")
    void getClientIndex() {
        //Act
        userRepository.saveClient(followerList);
        Integer index = userRepository.getClientIndex(followerList);
        //Assert
        assertEquals(1, index);
    }

    @Test
    @DisplayName("Deberia retornar el indice del vendedor")
    void getSellerIndex() {
        //Arrange
        User user = new User(2, "user", true);
        followerList.setUser(user);
        //Act
        userRepository.saveSeller(followerList);
        Integer index = userRepository.getSellerIndex(followerList);
        //Assert
        assertEquals(0, index);
    }

    @Test
    @DisplayName("Deberia retornar el usuario por id")
    void findSellerById() {
        //Act
        FollowerList returnedFollowerList = userRepository.findSellerById(2);
        //Assert
        assertTrue(returnedFollowerList.getUser().getUserId().equals(2));
    }

    @Test
    @DisplayName("Deberia retornar el usuario por id")
    void findClientById() {
        //Act
        FollowerList returnedFollowerList = userRepository.findClientById(1);
        //Assert
        assertTrue(returnedFollowerList.getUser().getUserId().equals(1));
    }

    @Test
    @DisplayName("Deberia retornar el cliente por id despues de actualizarlo")
    void updateClients() {
        //Act
        userRepository.saveClient(followerList);
        userRepository.updateClients(0, followerList);
        //Assert
        assertEquals(followerList, userRepository.findClientById(1));
    }

    @Test
    @DisplayName("Deberia retornar el vendedor por id despues de actualizarlo")
    void updateSellers() {
        //Act
        userRepository.saveSeller(followerList);
        userRepository.updateSellers(0, followerList);
        //Assert
        assertEquals(followerList, userRepository.findSellerById(1));
    }
    @Test
    @DisplayName("Trae el vendedor con el id 2")
    void  findSellerByIdTest(){
        //Arrange
        FollowerList expectedResult = FollowerList.builder()
                .user(new User(2,"dclail1",true))
                .follower(List.of(
                        new User( 3, "ceverett2",false),
                        new User(1,"wcalderwood0",false)
                ))
                .build();
        //Act
        FollowerList result= userRepository.findSellerById(2);
        //Assert
        assertThat(result,samePropertyValuesAs(expectedResult));
    }
    @Test
    @DisplayName("Traer el cliente con el id 3")
    void  findClientByIdTest(){
        //Arrange
        FollowerList expectedResult = FollowerList.builder()
                .user(new User(3,"ceverett2",false))
                .follower(List.of(
                        new User(2,"dclail1",true),
                        new User(5,"msynnott4",true)
                ))
                .build();
        //Act
        FollowerList result=userRepository.findClientById(3);
        //Assert
        assertThat(result,samePropertyValuesAs(expectedResult));
    }
}