package org.example.sprint1.repository;

import org.example.sprint1.entity.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getCustomersThatFollowsSellersById(int id);
    Customer findCustomerById(int id);
    boolean userIdToFollowCustomer(int userId, int userIdToFollow);
}
