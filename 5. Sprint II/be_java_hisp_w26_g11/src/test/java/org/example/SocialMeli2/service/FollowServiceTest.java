package org.example.SocialMeli2.service;

import org.example.SocialMeli2.dto.CountFollowersDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.SocialMeli2.dto.BasicSellerDTO;
import org.example.SocialMeli2.dto.FollowedSellersDTO;
import org.example.SocialMeli2.dto.SellerFollowerDto;
import org.example.SocialMeli2.entity.Customer;
import org.example.SocialMeli2.entity.Seller;
import org.example.SocialMeli2.exception.BadRequestException;
import org.example.SocialMeli2.exception.NotFoundException;
import org.example.SocialMeli2.repository.ICustomerRepository;
import org.example.SocialMeli2.repository.ISellerRepository;
import org.example.SocialMeli2.service.follow.FollowService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

/**
 * Clase de prueba para el servicio de seguimiento.
 * Esta clase contiene varios casos de prueba para validar la funcionalidad del servicio de seguimiento.
 */
@ExtendWith(MockitoExtension.class)
public class FollowServiceTest {
    @Mock
    ICustomerRepository customerRepository;

    @Mock
    ISellerRepository sellerRepository;

    @InjectMocks
    FollowService followService;


    /**
     * Prueba para validar correctamente el seguimiento.
     * <p>
     * Este método de prueba verifica que el usuario y el vendedor que se intenta seguir no existan en la base de datos.
     * Se configura el comportamiento esperado de los mocks para que retornen false, indicando que el usuario y el vendedor no están siguiéndose.
     * Luego, se ejecuta el método userIdToFollow del servicio FollowService.
     * Finalmente, se verifican las interacciones con los métodos userIdToFollowCustomer y userIdToFollowSeller de los repositorios correspondientes.
     */
    @Test
    @DisplayName("T-0001 validar correctamente follow")
    public void validateSuccessfullyFollow() {
        when(sellerRepository.userIdToFollowSeller(235, 101)).thenReturn(false);
        when(customerRepository.userIdToFollowCustomer(235, 101)).thenReturn(false);

        followService.userIdToFollow(235, 101);

        verify(customerRepository, times(1)).userIdToFollowCustomer(235, 101);
        verify(sellerRepository, times(1)).userIdToFollowSeller(235, 101);
    }

    /**
     * Prueba para validar de forma incorrecta el vendedor de seguimiento.
     * <p>
     * Este método de prueba verifica que el usuario no esté siguiendo al vendedor que se intenta seguir.
     * Se configura el comportamiento esperado de los mocks para que retornen true para el vendedor, indicando que el usuario ya está siguiendo al vendedor.
     * Luego, se ejecuta el método userIdToFollow del servicio FollowService y se espera que se lance una excepción BadRequestException.
     */
    @Test
    @DisplayName("T-0001 validar de forma incorrecta vendedor de follow")
    public void validateIncorrectlySellerFollow() throws BadRequestException {
        when(sellerRepository.userIdToFollowSeller(235, 90)).thenReturn(true);
        when(customerRepository.userIdToFollowCustomer(235, 90)).thenReturn(false);

        Assertions.assertThrows(BadRequestException.class, () -> followService.userIdToFollow(235, 90));
    }

    /**
     * Prueba para validar de forma incorrecta el comprador de seguimiento.
     * <p>
     * Este método de prueba verifica que el vendedor no esté siguiendo al usuario que se intenta seguir.
     * Se configura el comportamiento esperado de los mocks para que retornen true para el usuario, indicando que el vendedor ya está siguiendo al usuario.
     * Luego, se ejecuta el método userIdToFollow del servicio FollowService y se espera que se lance una excepción BadRequestException.
     */
    @Test
    @DisplayName("T-0001 validar de forma incorrecta comprador de follow")
    public void validateIncorrectlyBuyerFollow() throws BadRequestException {
        when(sellerRepository.userIdToFollowSeller(200, 101)).thenReturn(false);
        when(customerRepository.userIdToFollowCustomer(200, 101)).thenReturn(true);

        Assertions.assertThrows(BadRequestException.class, () -> followService.userIdToFollow(200, 101));
    }

    /**
     * Prueba para validar que el usuario a dejar de seguir exista.
     * <p>
     * Este método de prueba verifica que el usuario y el vendedor que se intenta dejar de seguir existan en la base de datos.
     * Se configura el comportamiento esperado de los mocks para que retornen un vendedor y un cliente existentes.
     * Luego, se ejecuta el método unfollowSeller del servicio FollowService.
     * Finalmente, se verifican las interacciones con los métodos getSellerById y findCustomerById de los repositorios correspondientes.
     */
    @Test
    @DisplayName("T-0002 Validación correcta de que el usuario a dejar de seguir exista")
    public void testValidUserIdToUnfollow() {

        // Configurar el comportamiento esperado de los mocks
        when(sellerRepository.getSellerById(101)).thenReturn(new Seller()); // Vendedor existe
        when(customerRepository.findCustomerById(235)).thenReturn(new Customer()); // Cliente existe

        // Ejecutar
        followService.unfollowSeller(235, 101);

        // Verificar interacciones
        verify(sellerRepository, times(1)).getSellerById(101);
        verify(customerRepository, times(1)).findCustomerById(235);
    }

    /**
     * Prueba para validar que el usuario a dejar de seguir no exista.
     * <p>
     * Este método de prueba verifica que el vendedor no exista y que el cliente sí exista en la base de datos.
     * Se configura el comportamiento esperado de los mocks para que retornen null para el vendedor y un cliente existente.
     * Luego, se ejecuta el método unfollowSeller del servicio FollowService y se espera que se lance una excepción NotFoundException.
     * Finalmente, se verifican las interacciones con los métodos getSellerById y findCustomerById de los repositorios correspondientes.
     */
    @Test
    @DisplayName("T-0002 Validación incorrecta de que el usuario a dejar de seguir exista")
    public void testUnvalidUserToUnfollow() {
        // Configurar el comportamiento esperado de los mocks
        when(sellerRepository.getSellerById(404)).thenReturn(null); // Vendedor no existe
        when(customerRepository.findCustomerById(235)).thenReturn(new Customer()); // Asumimos que el cliente sí existe

        // Verificar que se lanza la excepción NotFoundException
        Assertions.assertThrows(NotFoundException.class, () -> followService.unfollowSeller(235, 404));

        // Verificar que los métodos fueron invocados
        verify(sellerRepository, times(1)).getSellerById(404);
        verify(customerRepository, times(1)).findCustomerById(235);
    }

    /**
     * Prueba para verificar que la cantidad de seguidores de un usuario sea correcta.
     * <p>
     * Este método de prueba configura un vendedor con una lista de seguidores y luego verifica que el método countFollowers del servicio FollowService retorne la cantidad correcta de seguidores.
     */
    @Test
    @DisplayName("T-0007 Verificar que la cantidad de seguidores de un usuario sea correcta")
    public void testCountFollowersToUser() {
        //Arrange
        Seller seller = new Seller();
        seller.setSellerId(1);
        seller.setSellerName("ElectroJoaquin");
        seller.setFollowers(Arrays.asList(1,2,3));
        when(sellerRepository.getSellerById(1)).thenReturn(seller);
        CountFollowersDTO result = followService.countFollowers(1);
        //Act and Assert
        assertEquals(3, result.getFollowersCount());
    }

    /**
     * Prueba para verificar cuando no se encuentra el vendedor.
     * <p>
     * Este método de prueba configura el comportamiento esperado del mock para que retorne null cuando se busque un vendedor por su ID.
     * Luego, se ejecuta el método countFollowers del servicio FollowService y se espera que se lance una excepción NotFoundException.
     */
    @Test
    @DisplayName("T-0007 Verificar cuando no se encuentra el vendedor")
    public void testCountFollowersToUserWithNotFound() throws NotFoundException {
        //Arrange
        when(sellerRepository.getSellerById(anyInt())).thenReturn(null);
        //Act and Assert
        Assertions.assertThrows(NotFoundException.class, () -> followService.countFollowers(anyInt()));
    }

    /**
     * Prueba para validar que el ordenamiento exista.
     * <p>
     * Este método de prueba verifica que el ordenamiento por nombre ascendente y descendente exista.
     * Se configura el comportamiento esperado de los mocks para que retornen un vendedor y dos clientes.
     * Luego, se ejecuta el método getSellerFollowers del servicio FollowService.
     * Finalmente, se verifica que no se lance ninguna excepción.
     */
    @Test
    @DisplayName("T-0003 Validar el ordenamiento exista")
    public void testGetSellerFollowersWithValidOrder() {
        // Arrange
        Seller seller = new Seller();
        seller.setSellerName("seller1");
        when(sellerRepository.getSellerById(anyInt())).thenReturn(seller);

        Customer customer1 = new Customer();
        customer1.setUserId(1);
        customer1.setUserName("customer1");
        customer1.setSellers(Arrays.asList(1, 2, 3));

        Customer customer2 = new Customer();
        customer2.setUserId(2);
        customer2.setUserName("customer2");
        customer2.setSellers(Arrays.asList(4, 5, 6));

        when(customerRepository.getCustomersThatFollowsSellersById(anyInt())).thenReturn(Arrays.asList(customer1, customer2));

        // Act
        assertDoesNotThrow(() -> followService.getSellerFollowers(1, "name_asc"));
        assertDoesNotThrow(() -> followService.getSellerFollowers(1, "name_desc"));
    }

    /**
     * Prueba para validar que el ordenamiento no exista.
     * <p>
     * Este método de prueba verifica que el ordenamiento no exista.
     * Se configura el comportamiento esperado de los mocks para que retornen un vendedor y dos clientes.
     * Luego, se ejecuta el método getSellerFollowers del servicio FollowService.
     * Finalmente, se verifica que se lance una excepción BadRequestException.
     */
    @Test
    @DisplayName("T-0003 Validar la excepcion de un prdenamiento innexistente")
    public void testGetSellerFollowersWithInvalidOrder() {
        // Arrange
        Seller seller = new Seller();
        seller.setSellerName("seller1");
        when(sellerRepository.getSellerById(anyInt())).thenReturn(seller);
        when(customerRepository.getCustomersThatFollowsSellersById(anyInt())).thenReturn(Arrays.asList(new Customer(), new Customer()));

        // Act and Assert
        assertThrows(BadRequestException.class, () -> followService.getSellerFollowers(1, "invalid_order"));
    }

    /**
     * Prueba para validar el ordenamiento ascendente.
     * <p>
     * Este método de prueba verifica que el ordenamiento por nombre sea ascendente.
     * Se configura el comportamiento esperado de los mocks para que retornen un vendedor y dos clientes.
     * Luego, se ejecuta el método getSellerFollowers del servicio FollowService.
     * Finalmente, se verifica que los nombres de los clientes estén en orden ascendente.
     */
    @Test
    @DisplayName("T-0004 Validar el ordenamiento ascendente")
    public void testGetSellerFollowersWithAscendingOrder() {
        // Arrange
        Seller seller = new Seller();
        seller.setSellerName("seller1");
        when(sellerRepository.getSellerById(anyInt())).thenReturn(seller);

        Customer customer1 = new Customer();
        customer1.setUserId(1);
        customer1.setUserName("customerB");
        customer1.setSellers(Arrays.asList(1, 2, 3));

        Customer customer2 = new Customer();
        customer2.setUserId(2);
        customer2.setUserName("customerA");
        customer2.setSellers(Arrays.asList(4, 5, 6));

        when(customerRepository.getCustomersThatFollowsSellersById(anyInt())).thenReturn(Arrays.asList(customer1, customer2));

        // Act
        SellerFollowerDto result = followService.getSellerFollowers(1, "name_asc");

        // Assert
        assertEquals("customerA", result.getFollowers().get(0).getUserName());
        assertEquals("customerB", result.getFollowers().get(1).getUserName());
    }

    /**
     * Prueba para validar el ordenamiento descendente.
     * <p>
     * Este método de prueba verifica que el ordenamiento por nombre sea descendente.
     * Se configura el comportamiento esperado de los mocks para que retornen un vendedor y dos clientes.
     * Luego, se ejecuta el método getSellerFollowers del servicio FollowService.
     * Finalmente, se verifica que los nombres de los clientes estén en orden descendente.
     */
    @Test
    @DisplayName("T-0004 Validar el ordenamiento descendente")
    public void testGetSellerFollowersWithDescendingOrder() {
        // Arrange
        Seller seller = new Seller();
        seller.setSellerName("seller1");
        when(sellerRepository.getSellerById(anyInt())).thenReturn(seller);

        Customer customer1 = new Customer();
        customer1.setUserId(1);
        customer1.setUserName("customerA");
        customer1.setSellers(Arrays.asList(1, 2, 3));

        Customer customer2 = new Customer();
        customer2.setUserId(2);
        customer2.setUserName("customerB");
        customer2.setSellers(Arrays.asList(4, 5, 6));

        when(customerRepository.getCustomersThatFollowsSellersById(anyInt())).thenReturn(Arrays.asList(customer1, customer2));

        // Act
        SellerFollowerDto result = followService.getSellerFollowers(1, "name_desc");

        // Assert
        assertEquals("customerB", result.getFollowers().get(0).getUserName());
        assertEquals("customerA", result.getFollowers().get(1).getUserName());
    }

    /**
     * Prueba para validar que el orden de la lista de los vendedores que un usuario sigue este ASC.
     * <p>
     * Este método de prueba verifica que el orden de la lista de los vendedores que un usuario sigue sea ascendente.
     * Se configura el comportamiento esperado de los mocks para que retornen un cliente y tres vendedores.
     * Luego, se ejecuta el método getFollowedSellers del servicio FollowService.
     * Finalmente, se verifica que los nombres de los vendedores estén en orden ascendente.
     */
    @Test
    @DisplayName("T-0004 Validar que el orden de la lista de los vendedores que un usuario sigue este ASC")
    public void getFollowedSellersTestAsc() {

        // Arrange
        List<Seller> sellers = List.of(
                new Seller(1, "Juan", null, null),
                new Seller(2, "Andres", null, null),
                new Seller(3, "Diego", null, null)
        );

        List<BasicSellerDTO> sellersFollowed = Stream.of(
                        new BasicSellerDTO(1, "Juan", null, null),
                        new BasicSellerDTO(2, "Andres", null, null),
                        new BasicSellerDTO(3, "Diego", null, null)
                )
                .sorted(Comparator.comparing(BasicSellerDTO::getSellerName)).collect(Collectors.toList());;

        List<Integer> sellersIdFollowed = List.of(1, 2, 3);

        Customer customer = new Customer();
        customer.setUserId(1);
        customer.setUserName("Customer1");
        customer.setSellers(sellersIdFollowed);

        FollowedSellersDTO expectedResponse = new FollowedSellersDTO();
        expectedResponse.setUserId(customer.getUserId());
        expectedResponse.setCustomerName(customer.getUserName());
        expectedResponse.setFollowed(sellersFollowed);

        // Act
        ObjectMapper mapper = new ObjectMapper();

        when(customerRepository.findCustomerById(1)).thenReturn(customer);
        when(sellerRepository.getCustomersThatFollowsSellersById( 1 ) ).thenReturn(sellers);

        FollowedSellersDTO response = followService.getFollowedSellers(1, "name_asc");

        // Assert
        Assertions.assertEquals(expectedResponse, response);
    }

    /**
     * Prueba para validar que el orden de la lista de los vendedores que un usuario sigue este DESC.
     * <p>
     * Este método de prueba verifica que el orden de la lista de los vendedores que un usuario sigue sea descendente.
     * Se configura el comportamiento esperado de los mocks para que retornen un cliente y tres vendedores.
     * Luego, se ejecuta el método getFollowedSellers del servicio FollowService.
     * Finalmente, se verifica que los nombres de los vendedores estén en orden descendente.
     */
    @Test
    @DisplayName("T-0004 Validar que el orden de la lista de los vendedores que un usuario sigue este DESC")
    public void getFollowedSellersTestDesc() {

        // Arrange
        List<Seller> sellers = List.of(
                new Seller(1, "Juan", null, null),
                new Seller(2, "Andres", null, null),
                new Seller(3, "Diego", null, null)
        );

        List<BasicSellerDTO> sellersFollowed = Stream.of(
                        new BasicSellerDTO(1, "Juan", null, null),
                        new BasicSellerDTO(2, "Andres", null, null),
                        new BasicSellerDTO(3, "Diego", null, null)
                )
                .sorted(Comparator.comparing(BasicSellerDTO::getSellerName).reversed()).collect(Collectors.toList());;

        List<Integer> sellersIdFollowed = List.of(1, 2, 3);

        Customer customer = new Customer();
        customer.setUserId(1);
        customer.setUserName("Customer1");
        customer.setSellers(sellersIdFollowed);

        FollowedSellersDTO expectedResponse = new FollowedSellersDTO();
        expectedResponse.setUserId(customer.getUserId());
        expectedResponse.setCustomerName(customer.getUserName());
        expectedResponse.setFollowed(sellersFollowed);

        // Act
        ObjectMapper mapper = new ObjectMapper();

        when(customerRepository.findCustomerById(1)).thenReturn(customer);
        when(sellerRepository.getCustomersThatFollowsSellersById( 1 ) ).thenReturn(sellers);

        FollowedSellersDTO response = followService.getFollowedSellers(1, "name_desc");

        // Assert
        Assertions.assertEquals(expectedResponse, response);
    }

    /**
     * Prueba para validar getSellerFollowed con orden valido.
     * <p>
     * Este método de prueba verifica que el ordenamiento por nombre ascendente y descendente exista.
     * Se configura el comportamiento esperado de los mocks para que retornen un cliente y tres vendedores.
     * Luego, se ejecuta el método getFollowedSellers del servicio FollowService.
     * Finalmente, se verifica que no se lance ninguna excepción.
     */
    @Test
    @DisplayName("T-0003 Validar getSellerFollowed con orden valido")
    public void getSellerFollowedWithValidOrderTest() {
        // Arrange
        List<Seller> sellers = List.of(
                new Seller(1, "Juan", null, null),
                new Seller(2, "Andres", null, null),
                new Seller(3, "Diego", null, null)
        );

        List<BasicSellerDTO> sellersFollowed = Stream.of(
                        new BasicSellerDTO(1, "Juan", null, null),
                        new BasicSellerDTO(2, "Andres", null, null),
                        new BasicSellerDTO(3, "Diego", null, null)
                )
                .sorted(Comparator.comparing(BasicSellerDTO::getSellerName).reversed()).collect(Collectors.toList());;

        List<Integer> sellersIdFollowed = List.of(1, 2, 3);

        Customer customer = new Customer();
        customer.setUserId(1);
        customer.setUserName("Customer1");
        customer.setSellers(sellersIdFollowed);

        FollowedSellersDTO expectedResponse = new FollowedSellersDTO();
        expectedResponse.setUserId(customer.getUserId());
        expectedResponse.setCustomerName(customer.getUserName());


        // Act
        when(customerRepository.findCustomerById(1)).thenReturn(customer);
        when(sellerRepository.getCustomersThatFollowsSellersById(anyInt())).thenReturn(sellers);


        // Assert
        assertDoesNotThrow(() -> followService.getFollowedSellers(1, "name_asc"));
        assertDoesNotThrow(() -> followService.getFollowedSellers(1, "name_desc"));
    }

    /**
     * Prueba para validar getSellerFollowed con orden invalido.
     * <p>
     * Este método de prueba verifica que el ordenamiento no exista.
     * Se configura el comportamiento esperado de los mocks para que retornen un cliente y tres vendedores.
     * Luego, se ejecuta el método getFollowedSellers del servicio FollowService.
     * Finalmente, se verifica que se lance una excepción BadRequestException.
     */
    @Test
    @DisplayName("T-0003 Validar getSellerFollowed con orden invalido")
    public void testGetFollowedSellersWithInvalidOrder() {
        // Arrange
        List<Seller> sellers = List.of(
                new Seller(1, "Juan", null, null),
                new Seller(2, "Andres", null, null),
                new Seller(3, "Diego", null, null)
        );

        List<BasicSellerDTO> sellersFollowed = Stream.of(
                        new BasicSellerDTO(1, "Juan", null, null),
                        new BasicSellerDTO(2, "Andres", null, null),
                        new BasicSellerDTO(3, "Diego", null, null)
                )
                .sorted(Comparator.comparing(BasicSellerDTO::getSellerName).reversed()).collect(Collectors.toList());;

        List<Integer> sellersIdFollowed = List.of(1, 2, 3);

        Customer customer = new Customer();
        customer.setUserId(1);
        customer.setUserName("Customer1");
        customer.setSellers(sellersIdFollowed);

        FollowedSellersDTO expectedResponse = new FollowedSellersDTO();
        expectedResponse.setUserId(customer.getUserId());
        expectedResponse.setCustomerName(customer.getUserName());

        // Act
        when(customerRepository.findCustomerById(1)).thenReturn(customer);
        when(sellerRepository.getCustomersThatFollowsSellersById(anyInt())).thenReturn(sellers);

        // Assert
        assertThrows(BadRequestException.class, () -> followService.getFollowedSellers(1, "invalid_order"));
    }

}
