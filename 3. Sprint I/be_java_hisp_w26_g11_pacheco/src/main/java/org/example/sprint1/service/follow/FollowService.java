package org.example.sprint1.service.follow;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.sprint1.dto.*;
import org.example.sprint1.exception.BadRequestException;
import org.example.sprint1.repository.ICustomerRepository;
import org.example.sprint1.repository.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.sprint1.entity.Customer;
import org.example.sprint1.entity.Seller;
import org.example.sprint1.exception.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Stream;
import java.util.stream.Collectors;


@Service
public class FollowService implements IFollowService {

    @Autowired
    ICustomerRepository customerRepository;
    @Autowired
    ISellerRepository sellerRepository;


    @Override
    public void userIdToFollow(int userId, int userIdToFollow) {
        // se optiene el resultado si existen id
        boolean cusomerResult = customerRepository.userIdToFollowCustomer(userId, userIdToFollow);
        boolean sellerResult = sellerRepository.userIdToFollowSeller(userId, userIdToFollow);

        if (sellerResult || cusomerResult) {
            throw new BadRequestException("id no encontrado");
        }
    }


    @Override
    public CountFollowersDTO countFollowers(int sellerId) {
        Seller seller = sellerRepository.getSellerById(sellerId);
        if(seller == null){
            throw new NotFoundException("Vendedor no encontrado");
        }
        return new CountFollowersDTO(
                sellerId,seller.getSellerName(),seller.getFollowers().size()
        );
    }


    @Override
    public void unfollowSeller(int userId, int userIdToFollow) {
        Seller seller = sellerRepository.getSellerById(userIdToFollow);
        Customer customer = customerRepository.findCustomerById(userId);
        if(seller == null){
            throw new NotFoundException("Vendedor no encontrado");
        }
        if(customer == null){
            throw new NotFoundException("Cliente no encontrado");
        }
        // Remover el sellerId de la lista de vendedores que el usuario está siguiendo
        customer.getSellers().removeIf(sellerIdFollowed -> sellerIdFollowed == userIdToFollow);
        // Remover el userId de la lista de seguidores del vendedor
        seller.getFollowers().removeIf(followerId -> followerId == userId);
    }

    @Override
    public SellerFollowerDto getSellerFollowers(int userId, String order) {
        ObjectMapper mapper = new ObjectMapper();
        Seller seller =  sellerRepository.getSellerById(userId);

        Stream<BasicCustomerDto> customerStream = customerRepository.getCustomersThatFollowsSellersById(userId)
                .stream()
                .map(v -> mapper.convertValue(v, BasicCustomerDto.class));

        if ("name_asc".equals(order)) {
            customerStream = customerStream.sorted(Comparator.comparing(BasicCustomerDto::getUserName));
        } else if ("name_desc".equals(order)) {
            customerStream = customerStream.sorted(Comparator.comparing(BasicCustomerDto::getUserName).reversed());
        }
        return new SellerFollowerDto(userId, seller.getSellerName(), customerStream.toList());
    }
    @Override
    public FollowedSellersDTO getFollowedSellers(int userId, String order) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        Customer customer  =  customerRepository.findCustomerById(userId);
        if(customer == null) throw new NotFoundException("Usuario no encontrado");

        List<BasicSellerDTO> sellers = sellerRepository.getCustomersThatFollowsSellersById(userId)
                .stream().map( v -> mapper.convertValue(v, BasicSellerDTO.class)).collect(Collectors.toList());

        if ("name_asc".equals(order)) {
            sellers.sort(Comparator.comparing(BasicSellerDTO::getSellerName));
        } else if ("name_desc".equals(order)) {
            sellers.sort(Comparator.comparing(BasicSellerDTO::getSellerName).reversed());
        }

        return new FollowedSellersDTO(userId, customer.getUserName(), sellers);
    }
}
