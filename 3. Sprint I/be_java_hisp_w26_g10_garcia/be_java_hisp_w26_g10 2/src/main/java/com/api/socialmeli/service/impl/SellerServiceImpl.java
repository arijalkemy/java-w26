package com.api.socialmeli.service.impl;

import com.api.socialmeli.dto.*;
import com.api.socialmeli.entity.Buyer;
import com.api.socialmeli.entity.Post;
import com.api.socialmeli.entity.Seller;
import com.api.socialmeli.exception.BadRequestException;
import com.api.socialmeli.exception.NotFoundException;
import com.api.socialmeli.repository.IBuyerRepository;
import com.api.socialmeli.repository.IPostRepository;
import com.api.socialmeli.repository.ISellerRepository;
import com.api.socialmeli.service.IPostService;
import com.api.socialmeli.service.ISellerService;
import com.api.socialmeli.utils.UserDtoShort;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
    @Autowired
    IPostRepository iPostRepository;

    @Override
    public Seller getSellerById(Integer id) {
        Seller seller = iSellerRepository.getById(id);
        if (seller == null) throw new NotFoundException("El usuario no existe o no se encuentra registrado.");
        return seller;
    }
    
    // Obtenemos la cuenta de las personas que siguen a un determinado vendedor
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

    @Override
    public List<CompletePostDto> getPost(Integer userId) {
        //Buscar con el id a el vendedor
        Seller seller = iSellerRepository.getById(userId);

        //Se obtienen todos las publicaciones
        List<Post> posts = iPostRepository.getAll();
        //Se crea el mapper para transformar el post en el DTO que devuelve a el controlador
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        //filtra las publicaciones que hayan sido publicadas bajo el userId recibido por parametro
        return posts.stream().filter(post -> post.getUser_id().equals(seller.getUser_id())).
                map(post -> {
                            CompletePostDto completePostDto = mapper.convertValue(post, CompletePostDto.class);
                            completePostDto.setHas_promo(post.isHas_promo());
                            completePostDto.setDiscount(post.getDiscount());
                            return completePostDto;
                        }
                ).collect(Collectors.toList());
    }

    @Override
    public UserDiscountProducts getDiscountProductsBySeller(Integer userId) {
        //Buscar con el id a el vendedor
        Seller seller = iSellerRepository.getById(userId);
        //Con la funcion getPost se obtienen los post de un vendedor con el id
        List<CompletePostDto> posts = getPost(userId);
        //Se filtra la lista de post por los que tiene descuento
        return new UserDiscountProducts(
                seller.getUser_id(),
                seller.getUser_name(),
                posts.stream().filter(CompletePostDto::isHas_promo).toList());
    }

    @Override
    public UserDiscountProductsCount getCountDiscountProductsBySeller(Integer userId) {
        //Buscar con el id a el vendedor
        Seller seller = iSellerRepository.getById(userId);
        //Se crea y devuelve el dto con la informacion del usuario y la cuenta de sus publicaciones
        return new UserDiscountProductsCount(
                seller.getUser_id(), seller.getUser_name(),
                getDiscountProductsBySeller(userId).getPosts().size());
    }

    /*
    * US 0003 - Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
    * */
    @Override
    public FollowedBySellerDto getFollowersOfSeller(int seller_id, String order) {
        /* se realiza validacion dentro del id del venedor enviado */
        if(seller_id <= 0){
            throw new BadRequestException("El id del vendedor no puede ser menor o igual a cero");
        }

        /* se realiza validacion dentro del order enviado */
        if(!order.equals("name_desc") && !order.equals("name_asc") && !order.equals("")){
            throw new BadRequestException("El tipo de ordenamiento no es el permitido");
        }

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
        * lista de seguidos */
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
        List<UserDto> followersDto = buyersFollowers.stream()
                .map(buyer -> new UserDto(buyer.getUser_id(), buyer.getUser_name()))
                .collect(Collectors.toList());

        /* se comprueba forma de ordenamiento y se aplica el correspondiente*/
        List<UserDto> sortedList = UserDtoShort.sortList(followersDto, order);

        return new FollowedBySellerDto(
                seller.getUser_id(),
                seller.getUser_name(),
                sortedList
        );
    }
}
