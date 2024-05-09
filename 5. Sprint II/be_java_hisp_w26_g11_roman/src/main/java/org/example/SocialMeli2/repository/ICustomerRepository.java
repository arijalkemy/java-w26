package org.example.SocialMeli2.repository;

import org.example.SocialMeli2.entity.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getCustomersThatFollowsSellersById(int id);
    Customer findCustomerById(int id);
    boolean userIdToFollowCustomer(int userId, int userIdToFollow);
}
