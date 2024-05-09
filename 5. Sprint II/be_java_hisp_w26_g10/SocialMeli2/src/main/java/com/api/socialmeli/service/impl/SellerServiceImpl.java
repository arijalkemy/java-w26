package com.api.socialmeli.service.impl;

import com.api.socialmeli.dto.FollowedBySellerDto;
import com.api.socialmeli.dto.SellersCountFollowersDto;
import com.api.socialmeli.dto.UserDto;
import com.api.socialmeli.entity.Buyer;
import com.api.socialmeli.entity.Seller;
import com.api.socialmeli.exception.BadRequestException;
import com.api.socialmeli.exception.NotFoundException;
import com.api.socialmeli.mapper.ListUserMapper;
import com.api.socialmeli.repository.IBuyerRepository;
import com.api.socialmeli.repository.ISellerRepository;
import com.api.socialmeli.service.ISellerService;
import com.api.socialmeli.utils.FollowersOfSellerValidation;
import com.api.socialmeli.utils.UserDtoShort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SellerServiceImpl implements ISellerService {
    @Autowired
    ISellerRepository iSellerRepository;
    @Autowired
    IBuyerRepository iBuyerRepository;

    
    @Override
    public Seller getSellerById(Integer id) {
        Seller seller = iSellerRepository.getById(id);
        if (seller == null) throw new NotFoundException("El usuario no existe o no se encuentra registrado.");
        return seller;
    }

    /**
     * US-0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
     *
     * Obtenemos el total de followers que tiene un determinado vendedor
     * @param user_id id del usuario vendedor que buscamos
     * @return Devolvemos el DTO relacionado a la forma en que necesitamos visualizar
     * el numero total de followers de un determinado vendedor
     */
    @Override
    public SellersCountFollowersDto getCountOfSellerFollowers(Integer user_id) {
        //Obtenemos la lista de los vendedores y compradores
        List<Seller> sellerList = iSellerRepository.getAll();
        List<Buyer> buyerList = iBuyerRepository.getAll();

        // Creamos la instancia del DTO de salida
        SellersCountFollowersDto sellersCountFollowersDto = new SellersCountFollowersDto();
        int count = 0;
        boolean found = false;

        // Iteramos la lista de vendedores para saber si existe el id
        for (Seller seller : sellerList) {
            if (seller.getUser_id().equals(user_id)){
                // Seteamos los valores de user_name y user_id
                sellersCountFollowersDto.setUser_name(seller.getUser_name());
                sellersCountFollowersDto.setUser_id(seller.getUser_id());
                found = true;
                break;
            }

        }

        // Si no encontramos el id mandamos un NotFoundException
        if (!found) {
           throw new NotFoundException("There is no seller with that id");
        }

        // Por cada comprador en nuestra lista tenemos otra lista de vendedores que sigue, por lo que iteramos sobre ella
        // Y sumamos un 1 a la cuenta si es que el id coincide con el user_id de la lista de vendedores.

        count = (int) buyerList.stream()                       // Convertimos la lista de compradores a un stream
                .flatMap(buyer -> buyer.getFollowed().stream()) // Convertimos la lista de vendedores seguidos por cada comprador a un stream plano
                .filter(seller -> seller.getUser_id().equals(user_id)) // Filtrar los vendedores cuyo user_id coincide con el especificado
                .count();                                       // Contar el número de elementos en el stream resultante

        // Seteamos la cuenta total a nuestra instancia
        sellersCountFollowersDto.setFollowers_count(count);

        // Devolvemos nuestro objeto
        return sellersCountFollowersDto;

    }

    /**
     * @descripcion: US 0003 - Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
     * @param seller_id
     * @param order
     * @return returna la informacion de un vendedor mas su lista de seguidores con un order
     */
    @Override
    public FollowedBySellerDto getFollowersOfSeller(int seller_id, String order) {
        /* se comprueba el correcto formato de seller_id y de order */
        FollowersOfSellerValidation.isValidSellerId(seller_id);
        FollowersOfSellerValidation.isValidOrder(order);

        /* se comprueba que el vendedor exista */
        Seller seller = iSellerRepository.getById(seller_id);
        if(seller == null){
            throw new NotFoundException("No se encontro al vendedor con el id: " + Integer.toString(seller_id));
        }

        /* se optienen todos los compradores */
        List<Buyer> buyers = iBuyerRepository.getAll();
        if(buyers.isEmpty()){
            throw new NotFoundException("No hay compradores registrados");
        }

        /* se busca si el comprador sigue al vendedor y se agrega el comprador a
        * lista de seguidores del vendedor */
        List<Buyer> buyersFollowers = new ArrayList<>();
        for(Buyer buyer: buyers){
            Optional<Seller> sellerExist = buyer.getFollowed().stream()
                    .filter(x -> x.getUser_id().equals(seller_id)).findFirst();
            if(!sellerExist.isPresent()){
                buyersFollowers.add(buyer);
            }
        }

        /* se comprueba que el vendedor tenga seguidores */
        if(buyersFollowers.isEmpty()){
            throw new NotFoundException("No se encontraron seguidores de este comprador: " + Integer.toString(seller_id));
        }

        /* se crea su dto de respuesta */
        List<UserDto> followersDto = ListUserMapper.buyerListToUserDtoList(buyersFollowers);

        /* se comprueba forma de ordenamiento y se aplica el correspondiente*/
        List<UserDto> sortedList = UserDtoShort.sortList(followersDto, order);

        return new FollowedBySellerDto(
                seller.getUser_id(),
                seller.getUser_name(),
                sortedList
        );
    }
}
