package com.sprint.socialmeli.repository.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprint.socialmeli.entity.Customer;
import com.sprint.socialmeli.entity.Seller;
import com.sprint.socialmeli.entity.User;
import com.sprint.socialmeli.exception.ConflictException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Profile(value = "test")
@Repository
public class UsersRepositoryTestImpl implements IUsersRepository{
    private List<Customer> customerList = new ArrayList<>();
    private List<Seller> sellerList = new ArrayList<>();

    public UsersRepositoryTestImpl() {
        this.sellerList.add( new Seller(new User( 1,"Martin" ) ) );
        this.customerList.add( new Customer(new User( 2,"Jose" ) ) );
    }


    /**
     *
     * @param predicate filter expression to apply
     * @return a List of customer entities that comply with the predicate
     */
    @Override
    public List<Customer> findCustomerByPredicate(Predicate<Customer> predicate) {
        return customerList.stream().filter(predicate).toList();
    }

    /**
     *
     * @param predicate filter expression to apply
     * @return a List of sellers entities that comply with the predicate
     */
    @Override
    public List<Seller> findSellerByPredicate(Predicate<Seller> predicate) {
        return sellerList.stream().filter(predicate).toList();
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customerList.stream().filter(c -> c.getUser().getUserId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Seller findSellerById(Integer id) {
        return sellerList.stream().filter(s -> s.getUser().getUserId().equals(id)).findFirst().orElse(null);
    }
}
