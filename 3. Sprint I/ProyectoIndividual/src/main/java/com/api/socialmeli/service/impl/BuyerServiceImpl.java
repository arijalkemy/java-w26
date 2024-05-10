package com.api.socialmeli.service.impl;

import com.api.socialmeli.entity.Buyer;
import com.api.socialmeli.entity.Seller;
import com.api.socialmeli.exception.BadRequestException;
import com.api.socialmeli.repository.IBuyerRepository;
import com.api.socialmeli.repository.ISellerRepository;
import com.api.socialmeli.dto.BuyerFollowedListDTO;
import com.api.socialmeli.exception.NotFoundException;
import com.api.socialmeli.service.IBuyerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
@Service
public class BuyerServiceImpl implements IBuyerService {

    @Autowired
    private IBuyerRepository buyerRepository;

    @Autowired
    private ISellerRepository sellerRepository;

    @Override
    public List<Buyer> getAll() {
        return buyerRepository.getAll();
    }

    @Override
    public Buyer followUser(Integer userId, Integer userIdToFollow) {
        Seller userFollowed = sellerRepository.getById(userIdToFollow);
        Buyer userFollowing = buyerRepository.getById(userId);
        if(userFollowed == null || userFollowing == null){
            throw new BadRequestException("Comprador o vendedor no encontrado por Id");
        }
        if(userFollowing.getFollowed().contains(userFollowed)){
            throw new BadRequestException("Ya esta siguiendo al comprador");
        }
        return buyerRepository.followUser(userFollowing, userFollowed);
    }

    @Override
    public Buyer getBuyerById(Integer id) {
        return buyerRepository.getById(id);
    }
    /*
    US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
     */
    @Override
    public void unfollowUser(Integer followerId, Integer toUnfollowId) {
        Buyer buyer = buyerRepository.getById(followerId);
        if(buyer == null){
            throw new NotFoundException("El usuario no existe");
        }
        Seller sellerToUnfollow = buyer.getFollowed().
                                             stream().
                                             filter(e->e.getUser_id().equals(toUnfollowId)).
                                             findFirst().
                                             orElse(null);
        if(sellerToUnfollow == null){
            throw new NotFoundException("No sigues al vendedor ");
        }

        buyerRepository.getById(followerId).getFollowed().removeIf(e->e.getUser_id().equals(toUnfollowId));
    }
    //Servicio que implementa la logica para obtener la lista de todos los vendedores que sigue
    //un determinado usuario con la opcion de poder ordenarlo por nombre ascendente o descentente
    @Override
    public BuyerFollowedListDTO getFollowedListByUser(Integer user_id, String order) {
        ObjectMapper mapper = new ObjectMapper();
        //Se obtiene el usuario solicitado
        Buyer buyer = buyerRepository.getById(user_id);
        //Valida que sea un usario registrado
        if (buyer!=null){
            //revisa si se solicito un ordenamiento desde el controlador
            if (order!=null){
                //Ordenamiento ascendente mediante expresiones lambda
                if (order.equals("name_asc")){
                    buyer.setFollowed((buyer.getFollowed().stream()
                            .sorted(Comparator.comparing(Seller::getUser_name)).toList()));
                }else {
                    //Ordenamiento descendente mediante expresiones lambda
                    if (order.equals("name_desc")){
                        buyer.setFollowed((buyer.getFollowed().stream()
                                .sorted(Comparator.comparing(Seller::getUser_name).reversed()).toList()));
                    }else {
                        throw new BadRequestException("Parametros incorrectos para el ordenamiento");
                    }
                }
            }
            //Retorna la salida solicitada o en su caso las respectivas excepciones
            return mapper.convertValue(buyer,BuyerFollowedListDTO.class);
        }else {
            throw new NotFoundException("El usuario no existe o no se encuentra registrado.");
        }
    }
}
