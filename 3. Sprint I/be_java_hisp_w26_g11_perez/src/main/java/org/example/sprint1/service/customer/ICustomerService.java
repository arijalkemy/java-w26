package org.example.sprint1.service.customer;

import org.example.sprint1.dto.PostDTO;
import org.example.sprint1.dto.SuccessMessageDTO;
import org.example.sprint1.dto.customer.CustomerDTO;
import org.example.sprint1.dto.customer.CustomerRequestDTO;
import org.example.sprint1.dto.customer.CustomerResponseDTO;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> findAllCustomers();
    List<PostDTO> getPostWithFavoriteCategories(int userId);
    SuccessMessageDTO updateCustomerCategories(int userId, CustomerRequestDTO categories);
}
