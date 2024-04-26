package com.sprint.socialmeli.utils;

import com.sprint.socialmeli.entity.Customer;
import com.sprint.socialmeli.entity.Seller;
import com.sprint.socialmeli.exception.NotFoundException;
import com.sprint.socialmeli.repository.user.IUsersRepository;
import org.springframework.stereotype.Component;

@Component
public class UserChecker {

    private static IUsersRepository usersRepository;

    public UserChecker(IUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * @param customerId Customer id
     * @return a Customer entity
     * @throws NotFoundException if any of the users not exists in the repository
     *                           Checks if the users exists in the repository
     */
    public static Customer checkAndGetCustomer(Integer customerId) {
        Customer customer = usersRepository
                .findCustomerById(customerId);

        if (customer == null) {
            throw new NotFoundException("Customer with ID: " + customerId + " not found");
        }

        return customer;
    }

    /**
     * @param sellerId Seller id
     * @return a Seller entity
     * @throws NotFoundException if any of the users not exists in the repository
     *                           Checks if the users exists in the repository
     */
    public static Seller checkAndGetSeller(Integer sellerId) {
        Seller seller = usersRepository
                .findSellerById(sellerId);

        if (seller == null) {
            throw new NotFoundException("Seller with ID: " + sellerId + " not found");
        }

        return seller;
    }
}
