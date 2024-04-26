package org.example.sprint1.service.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.sprint1.dto.PostDTO;
import org.example.sprint1.dto.SuccessMessageDTO;
import org.example.sprint1.dto.customer.CustomerDTO;
import org.example.sprint1.dto.customer.CustomerRequestDTO;
import org.example.sprint1.entity.Customer;
import org.example.sprint1.entity.Post;
import org.example.sprint1.entity.Seller;
import org.example.sprint1.exception.NotFoundException;
import org.example.sprint1.repository.ICustomerRepository;
import org.example.sprint1.repository.SellerRepository;
import org.example.sprint1.service.seller.ISellerService;
import org.example.sprint1.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    ISellerService sellerService;

    ObjectMapper mapper = new ObjectMapper();

    public CustomerServiceImpl() {
        mapper.findAndRegisterModules();
    }

    @Override
    public List<CustomerDTO> findAllCustomers() {
        List<Customer> customers = customerRepository.getAllCustomers();

        return customers.stream()
                .map(customer -> mapper.convertValue(customer, CustomerDTO.class))
                .toList();
    }

    @Override
    public List<PostDTO> getPostWithFavoriteCategories(int userId) {
        Customer customer = customerRepository.findCustomerById(userId);
        if (customer == null) throw new NotFoundException("Cliente no encontrado");

        List<Seller> sellers = sellerRepository.getAllSellers();
        List<Post> posts = new ArrayList<>();

        for (Integer category : customer.getCategories()) {
            sellers.forEach(seller ->
                posts.addAll(
                    seller.getPosts().stream()
                            .filter(post -> post.getCategory() == category)
                            .toList()
                )
            );
        }

        List<PostDTO> postDTOs = posts.stream()
                .map(post -> mapper.convertValue(post, PostDTO.class))
                .toList();

        return postDTOs;
    }

    @Override
    public SuccessMessageDTO updateCustomerCategories(int userId, CustomerRequestDTO request) {
        Customer customer = customerRepository.findCustomerById(userId);
        if (customer == null) throw new NotFoundException("Cliente no encontrado");

        customer.setCategories(request.getCategories());

        return new SuccessMessageDTO("Cliente actualizado con éxito");
    }
}
