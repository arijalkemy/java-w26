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

/**
 * Implementación de la interfaz IFollowService.
 */
@Service
public class FollowService implements IFollowService {

    @Autowired
    ICustomerRepository customerRepository;
    @Autowired
    ISellerRepository sellerRepository;

    /**
     * Permite a un usuario seguir a otro usuario.
     *
     * @param userId El ID del usuario que desea seguir a otro usuario.
     * @param userIdToFollow El ID del usuario que será seguido.
     * @throws BadRequestException si el vendedor o el comprador no se encuentran.
     */
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

    /**
     * Cuenta el número de seguidores de un vendedor.
     *
     * @param sellerId El ID del vendedor.
     * @return Un objeto CountFollowersDTO que contiene el ID del vendedor, el nombre del vendedor y el número de seguidores.
     * @throws NotFoundException si el vendedor no se encuentra.
     */
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

    /**
     * Permite a un usuario dejar de seguir a un vendedor.
     *
     * @param userId El ID del usuario que desea dejar de seguir a un vendedor.
     * @param userIdToFollow El ID del vendedor que será dejado de seguir.
     * @throws NotFoundException si el vendedor o el cliente no se encuentran.
     */
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

    /**
     * Método genérico para ordenar una lista de objetos basado en un atributo de tipo String.
     *
     * @param list La lista de objetos a ordenar.
     * @param order El orden en el que se desea ordenar la lista. Puede ser "name_asc" para orden ascendente o "name_desc" para orden descendente.
     * @param getName Una función que toma un objeto de la lista y devuelve el atributo de tipo String por el cual se ordenará la lista.
     * @return La lista ordenada.
     * @throws BadRequestException si el parámetro de orden no es "name_asc" ni "name_desc".
     */
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

    /**
     * Obtiene los seguidores de un vendedor.
     *
     * @param userId El ID del vendedor.
     * @param order El orden en el que se desea ordenar la lista de seguidores. Puede ser "name_asc" para orden ascendente o "name_desc" para orden descendente.
     * @return Un objeto SellerFollowerDto que contiene el ID del vendedor, el nombre del vendedor y una lista de seguidores.
     * @throws NotFoundException si el vendedor no se encuentra.
     */
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

    /**
     * Obtiene los vendedores seguidos por un usuario.
     *
     * @param userId El ID del usuario.
     * @param order El orden en el que se desea ordenar la lista de vendedores seguidos. Puede ser "name_asc" para orden ascendente o "name_desc" para orden descendente.
     * @return Un objeto FollowedSellersDTO que contiene el ID del usuario, el nombre del usuario y una lista de vendedores seguidos.
     * @throws NotFoundException si el usuario no se encuentra.
     */
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
