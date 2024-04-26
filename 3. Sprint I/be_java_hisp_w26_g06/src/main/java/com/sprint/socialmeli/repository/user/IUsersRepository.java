package com.sprint.socialmeli.repository.user;

import com.sprint.socialmeli.entity.Customer;
import com.sprint.socialmeli.entity.Seller;

import java.util.List;
import java.util.function.Predicate;

public interface IUsersRepository {
    List<Customer> findCustomerByPredicate(Predicate<Customer> predicate);
    List<Seller> findSellerByPredicate(Predicate<Seller> predicate);
    Customer findCustomerById(Integer id);
    Seller findSellerById(Integer id);

}
