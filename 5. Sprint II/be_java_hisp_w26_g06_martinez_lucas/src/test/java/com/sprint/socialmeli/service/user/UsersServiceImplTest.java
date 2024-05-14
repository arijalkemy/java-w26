package com.sprint.socialmeli.service.user;

import com.sprint.socialmeli.dto.user.FollowerCountResponseDTO;
import com.sprint.socialmeli.dto.user.FollowedResponseDTO;
import com.sprint.socialmeli.dto.user.FollowersResponseDTO;
import com.sprint.socialmeli.dto.user.UserResponseDTO;
import com.sprint.socialmeli.entity.Customer;
import com.sprint.socialmeli.entity.IUser;
import com.sprint.socialmeli.entity.Seller;
import com.sprint.socialmeli.entity.User;
import com.sprint.socialmeli.exception.BadRequestException;
import com.sprint.socialmeli.exception.NotFoundException;
import com.sprint.socialmeli.mappers.UserMapper;
import com.sprint.socialmeli.repository.user.IUsersRepository;
import com.sprint.socialmeli.utils.NameOrderType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

import static com.sprint.socialmeli.mappers.UserMapper.mapUserToFollowerCountDto;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UsersServiceImplTest {

    @Mock
    IUsersRepository usersRepository;

    @InjectMocks
    UsersServiceImpl usersService;

    Seller seller;
    Customer customer;
    List<IUser> customerList;
    List<IUser> sellerList;

    @BeforeEach
    void setUp() {
        Integer sellerId = 1;
        Integer customerId = 101;
        seller = new Seller(new User(sellerId, "Martin"));
        customer = new Customer(new User(customerId, "Antonio"));

        customerList = new ArrayList<>(List.of(
                customer,
                new Customer(new User(102, "Nicolas"))
        ));
        sellerList = new ArrayList<>(List.of(
                seller,
                new Seller(new User(2, "Amanda")),
                new Seller(new User(3, "Francisco"))
        ));
    }

    // Verify user to follow exists - T-0001 -----------------START
    // ------ Good case ------
    @Test
    @DisplayName("User to follow exist")
    public void userToFollowExist() {
        // Act and Assert
        Mockito.when(usersRepository.findSellerById(seller.getUser().getUserId())).thenReturn(seller);
        Mockito.when(usersRepository.findCustomerById(customer.getUser().getUserId())).thenReturn(customer);

        assertDoesNotThrow(() -> usersService.follow(customer.getUser().getUserId(), seller.getUser().getUserId()));
    }

    // ------ Bad case ------
    @Test
    @DisplayName("User to follow does not exist")
    public void userToFollowDoesNotExist() {
        // Act and Assert
        Mockito.when(usersRepository.findSellerById(seller.getUser().getUserId())).thenReturn(null);
        Mockito.when(usersRepository.findCustomerById(customer.getUser().getUserId())).thenReturn(customer);

        assertThrows(NotFoundException.class, () -> usersService.follow(customer.getUser().getUserId(), seller.getUser().getUserId()));
    }
    // Verify user to follow exists - T-0001 ----------------- END

    // User to unfollow should exists - T-0002 -----------------START
    // Good case - Normal flow
    @Test
    @DisplayName("User to unfollow should exists")
    public void userToUnfollowExist(){

        // Mock of the customer who already follows the seller
        customer.setFollowed( new ArrayList<>(Arrays.asList(seller.getUser().getUserId())));

        // Act & Assert
        Mockito.when(usersRepository.findSellerById(seller.getUser().getUserId())).thenReturn(seller);
        Mockito.when(usersRepository.findCustomerById(customer.getUser().getUserId())).thenReturn(customer);

        assertDoesNotThrow(() -> usersService.unfollow(customer.getUser().getUserId(), seller.getUser().getUserId()));
    }

    // Bad case - Follower does not exist
    @Test
    @DisplayName("User to unfollow should exists")
    public void userToUnfollowDoesNotExist(){

        // Mock of the seller
        Mockito.when(usersRepository.findSellerById(seller.getUser().getUserId())).thenReturn(null);

        // Mock of the customer who already follows the seller
        customer.setFollowed(new ArrayList<>(Arrays.asList(seller.getUser().getUserId())));

        // Act & Assert
        Mockito.when(usersRepository.findCustomerById(customer.getUser().getUserId())).thenReturn(customer);

        assertThrows(NotFoundException.class, () -> usersService
                .unfollow(customer.getUser().getUserId(), seller.getUser().getUserId()));
    }
    // User to unfollow should exists - T-0002 -----------------END

    // Order by name unit tests - T-0003 -----------------START
    // ---- Bad case ------
    @Test
    @DisplayName("Order type name does not exist")
    void orderTypeDoesNotExists() {
        // Arrange
        String order = "asd";

        // Act & assert
        Mockito.when(usersRepository.findSellerById(seller.getUser().getUserId())).thenReturn(seller);
        assertThrows(BadRequestException.class, () -> usersService.getFollowers(seller.getUser().getUserId(), order));

    }

    // ---- Good case ------

    @Test
    @DisplayName("Order type 'name_asc' exists")
    void testOrderTypeNameAscExists() {
        this.orderTypeExists(NameOrderType.NAME_ASC);
    }

    @Test
    @DisplayName("Order type 'name_desc' exists")
    void testOrderTypeNameDescExists() {
        this.orderTypeExists(NameOrderType.NAME_DESC);
    }

    private void orderTypeExists(NameOrderType order) {
        // Act
        Mockito.when(
                usersRepository.findCustomerByPredicate(ArgumentMatchers.any())
        ).thenReturn(getCustomerList());

        Mockito.when(usersRepository.findSellerById(seller.getUser().getUserId())).thenReturn(seller);

        // Assert
        assertDoesNotThrow(() -> usersService.getFollowers(seller.getUser().getUserId(), order.name()));
    }
    // Order by name unit tests - T-0003 -------------------END

    // Order by name unit tests - T-0004 -------------------START
    @Test
    @DisplayName("Order type 'name_asc' returns follower list ordered descending by name")
    public void testOrderFollowersAscending() {
        testFollowersAreCorrectlyOrdered(NameOrderType.NAME_ASC);
    }

    @Test
    @DisplayName("Order type 'name_desc' returns follower list ordered descending by name")
    public void testOrderFollowersDescending() {
        testFollowersAreCorrectlyOrdered(NameOrderType.NAME_DESC);
    }

    @Test
    @DisplayName("No order type returns follower list in default order")
    public void testOrderFollowersDefaultOrder() {
        testFollowersAreCorrectlyOrdered(null);
    }

    @Test
    @DisplayName("Order type 'name_asc' returns followed list ordered descending by name")
    public void testOrderFollowedAscending() {
        testFollowedAreCorrectlyOrdered(NameOrderType.NAME_ASC);
    }

    @Test
    @DisplayName("Order type 'name_desc' returns followed list ordered descending by name")
    public void testOrderFollowedDescending() {
        testFollowedAreCorrectlyOrdered(NameOrderType.NAME_DESC);
    }

    @Test
    @DisplayName("No order type returns followed list in default order")
    public void testNoOrderTypeDefaultOrder() {
        testFollowedAreCorrectlyOrdered(null);
    }

    private void testFollowersAreCorrectlyOrdered(NameOrderType order) {
        List<UserResponseDTO> expected = arrangeOrderTests(customerList, order);

        Mockito.when(
                usersRepository.findCustomerByPredicate(ArgumentMatchers.any())
        ).thenReturn(getCustomerList());

        Mockito.when(usersRepository.findSellerById(seller.getUser().getUserId())).thenReturn(seller);

        //Act
        FollowersResponseDTO followersResponseDTO;
        if( order != null ) {
            followersResponseDTO = usersService.getFollowers(seller.getUser().getUserId(), order.name());
        }else{
            followersResponseDTO = usersService.getFollowers(seller.getUser().getUserId(), null);
        }

        //Assert
        Assertions.assertEquals(expected, followersResponseDTO.getFollowers());
    }

    private void testFollowedAreCorrectlyOrdered(NameOrderType order) {
        List<UserResponseDTO> expected = arrangeOrderTests(sellerList, order);

        Mockito.when(
                usersRepository.findSellerByPredicate(ArgumentMatchers.any())
        ).thenReturn(getSellerList());

        Mockito.when(usersRepository.findCustomerById(customer.getUser().getUserId())).thenReturn(customer);

        //Act
        FollowedResponseDTO followedResponseDTO;
        if( order != null ) {
            followedResponseDTO = usersService.listFollowedUsers(customer.getUser().getUserId(), order.name());
        }else{
            followedResponseDTO = usersService.listFollowedUsers(customer.getUser().getUserId(), null);
        }

        //Assert
        Assertions.assertEquals(expected, followedResponseDTO.getFollowed());
    }

    private List<UserResponseDTO> arrangeOrderTests(List<IUser> users,
                                                    NameOrderType order){
        //Arrange
        if (order != null) {
            if (order.equals(NameOrderType.NAME_ASC)) {
                users.sort(Comparator.comparing(customer -> customer.getUser().getUserName()));
            } else if (order.equals(NameOrderType.NAME_DESC)) {
                users.sort(Comparator
                        .comparing(customer -> customer.getUser().getUserName(), Comparator.reverseOrder()));
            }
        }

        return users
                .stream()
                .map(UserMapper::mapUserToUserResponseDto)
                .toList();
    }

    private List<Customer> getCustomerList() {
        return customerList.stream().map(customerUser -> (Customer) customerUser).toList();
    }

    private List<Seller> getSellerList() {
        return sellerList.stream().map(sellerUser -> (Seller) sellerUser).toList();
    }

    // Order by name unit tests - T-0004 -------------------END


    // Get correct followers count - T-007 -------------------START
    @Test
    @DisplayName("Get correct followers count")
    public void getFollowersCountTest() {

        Mockito.when(usersRepository.findSellerById(seller.getUser().getUserId())).thenReturn(seller);
        Mockito.when(
                usersRepository.findCustomerByPredicate(ArgumentMatchers.any())
        ).thenReturn(getCustomerList());
        //Act
        FollowerCountResponseDTO countDTO = usersService.getFollowersCount(seller.getUser().getUserId());

        FollowerCountResponseDTO expected = mapUserToFollowerCountDto(seller, customerList.size());

        //Assert
        Assertions.assertEquals(expected, countDTO);
    }
    // Get correct followers count - T-007 -------------------START

}