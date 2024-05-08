package com.javabootcamp.socialmeli.unit.repository;

import com.javabootcamp.socialmeli.model.Follow;
import com.javabootcamp.socialmeli.model.User;
import com.javabootcamp.socialmeli.repository.FollowRepository;
import com.javabootcamp.socialmeli.repository.FollowRepositoryImpl;
import com.javabootcamp.socialmeli.utils.UserBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class FollowRepositoryTest {
        FollowRepository followRepository;

        /**
         * Crea un repositorio de seguidores y les agrega un par de objetos para
         * realizar los tests
         */
        @BeforeEach
        void setUp() {
                User seller = UserBuilder.userSeller(1, "Marcos");
                User client = UserBuilder.userClient(2, "Franco");
                followRepository = new FollowRepositoryImpl();
                // creating follows with repeated seller
                followRepository.add(new Follow(
                                client,
                                seller,
                                LocalDate.now()));
                followRepository.add(new Follow(
                                UserBuilder.userClient(3, "Rodrigo"),
                                seller,
                                LocalDate.now()));
                followRepository.add(new Follow(
                                UserBuilder.userClient(4, "Ignacio"),
                                seller,
                                LocalDate.now()));
                // Creating follows with repeated client
                followRepository.add(new Follow(
                                client,
                                UserBuilder.userSeller(5, "Eliana"),
                                LocalDate.now()));
                followRepository.add(new Follow(
                                client,
                                UserBuilder.userSeller(6, "Juan"),
                                LocalDate.now()));
        }

        // T-0004 -> Followers asc
        @Test
        @DisplayName("T-0004 -> Corroborar que ordene correctamente de forma ascendente los seguidores de un vendedor")
        void getFollowersByIdOrdersAscCorrectly() {
                List<User> expected = List.of(
                                UserBuilder.userClient(2, "Franco"),
                                UserBuilder.userClient(4, "Ignacio"),
                                UserBuilder.userClient(3, "Rodrigo"));

                List<User> actual = followRepository.searchFollowersByUserAndOrderAsc(1);

                Assertions.assertIterableEquals(expected, actual);
        }

        // T-0004 -> Followers desc
        @Test
        @DisplayName("T-0004 -> Corroborar que ordene correctamente de forma descendente los seguidores de un vendedor")
        void getFollowersByIdOrdersDescCorrectly() {
                List<User> expected = List.of(
                                UserBuilder.userClient(3, "Rodrigo"),
                                UserBuilder.userClient(4, "Ignacio"),
                                UserBuilder.userClient(2, "Franco"));

                List<User> actual = followRepository.searchFollowersByUserAndOrderDesc(1);

                Assertions.assertIterableEquals(expected, actual);
        }

        // T-0004 -> Followed asc
        @Test
        @DisplayName("T-0004 -> Corroborar que ordene correctamente de forma ascendente los seguidos de un usuario")
        void getFollowedByIdOrdersAscCorrectly() {
                List<User> expected = List.of(
                                UserBuilder.userSeller(5, "Eliana"),
                                UserBuilder.userSeller(6, "Juan"),
                                UserBuilder.userSeller(1, "Marcos"));

                List<User> actual = followRepository.findFollowedsByIdAsc(2);

                Assertions.assertIterableEquals(expected, actual);
        }

        // T-0004 -> Followed desc
        @Test
        @DisplayName("T-0004 -> Corroborar que ordene correctamente de forma descendente los seguidos de un usuario")
        void getFollowedByIdOrdersDescCorrectly() {
                List<User> expected = List.of(
                                UserBuilder.userSeller(1, "Marcos"),
                                UserBuilder.userSeller(6, "Juan"),
                                UserBuilder.userSeller(5, "Eliana"));

                List<User> actual = followRepository.findFollowedsByIdDesc(2);

                Assertions.assertIterableEquals(expected, actual);
        }

        // T-0007

        @Test
        @DisplayName("T-0007 -> Verifica si la cantidad de seguidores de un vendedor es correcta")
        void testCountFollowersById() {
                int expected = 3;
                int result = followRepository.countFollowersById(1);
                Assertions.assertEquals(expected, result);

        }
}
