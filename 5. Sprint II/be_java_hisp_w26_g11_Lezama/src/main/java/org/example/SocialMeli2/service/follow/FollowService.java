package org.example.SocialMeli2.service.follow;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.SocialMeli2.dto.*;
import org.example.SocialMeli2.exception.BadRequestException;
import org.example.SocialMeli2.repository.ICustomerRepository;
import org.example.SocialMeli2.repository.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.SocialMeli2.entity.Customer;
import org.example.SocialMeli2.entity.Seller;
import org.example.SocialMeli2.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.function.Function;
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

        if (sellerResult) {
            throw new BadRequestException("vendedor no encontrado");
        }

        if (cusomerResult) {
            throw new BadRequestException("comprador no encontrado");
        }
    }


    @Override
    public CountFollowersDTO countFollowers(Integer sellerId) {
        Seller seller = sellerRepository.getSellerById(sellerId);
        if(seller == null){
            throw new NotFoundException("Vendedor no encontrado");
        }
        return new CountFollowersDTO(
                sellerId,seller.getSellerName(),seller.getFollowers().size()
        );
    }


    @Override
    public void unfollowSeller(Integer userId, Integer userIdToFollow) {
        Seller seller = sellerRepository.getSellerById(userIdToFollow);
        Customer customer = customerRepository.findCustomerById(userId);
        if(seller == null){
            throw new NotFoundException("Vendedor no encontrado");
        }
        if(customer == null){
            throw new NotFoundException("Cliente no encontrado");
        }

        // Asegurar que la lista de sellers no es null antes de intentar modificarla
        if (customer.getSellers() == null) {
            customer.setSellers(new ArrayList<>());
        }

        // Remover el sellerId de la lista de vendedores que el usuario está siguiendo
        customer.getSellers().removeIf(sellerIdFollowed -> sellerIdFollowed == userIdToFollow);

        // Asegurar que la lista de followers no es null antes de intentar modificarla
        if (seller.getFollowers() == null) {
            seller.setFollowers(new ArrayList<>());
        }

        // Remover el userId de la lista de seguidores del vendedor
        seller.getFollowers().removeIf(followerId -> followerId == userId);
    }

    private <T> List<T> sortList(List<T> list, String order, Function<T, String> getName) {
        if (order == null) {
            return list;
        }
        if ("name_asc".equals(order)) {
            return list.stream().sorted(Comparator.comparing(getName)).collect(Collectors.toList());
        } else if ("name_desc".equals(order)) {
            return list.stream().sorted(Comparator.comparing(getName).reversed()).collect(Collectors.toList());
        } else {
            throw new BadRequestException("Orden no válido: " + order);
        }
    }

    @Override
    public SellerFollowerDto getSellerFollowers(int userId, String order) {
        ObjectMapper mapper = new ObjectMapper();
        Seller seller =  sellerRepository.getSellerById(userId);
        if(seller == null) throw new NotFoundException("Vendedor no encontrado");

        List<BasicCustomerDto> customers = customerRepository.getCustomersThatFollowsSellersById(userId)
                .stream().map(v -> mapper.convertValue(v, BasicCustomerDto.class)).collect(Collectors.toList());

        customers = sortList(customers, order, BasicCustomerDto::getUserName);

        return new SellerFollowerDto(userId, seller.getSellerName(), customers);
    }

    @Override
    public FollowedSellersDTO getFollowedSellers(int userId, String order) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        Customer customer  =  customerRepository.findCustomerById(userId);
        if(customer == null) throw new NotFoundException("Usuario no encontrado");

        List<BasicSellerDTO> sellers = sellerRepository.getCustomersThatFollowsSellersById(userId)
                .stream().map( v -> mapper.convertValue(v, BasicSellerDTO.class)).collect(Collectors.toList());

        sellers = sortList(sellers, order, BasicSellerDTO::getSellerName);

        return new FollowedSellersDTO(userId, customer.getUserName(), sellers);
    }
}
