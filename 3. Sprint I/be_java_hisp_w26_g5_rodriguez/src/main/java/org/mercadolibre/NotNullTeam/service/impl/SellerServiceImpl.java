package org.mercadolibre.NotNullTeam.service.impl;

import lombok.RequiredArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.response.SellerFollowersCountDto;
import org.mercadolibre.NotNullTeam.DTO.response.SellerResponseDTO;
import org.mercadolibre.NotNullTeam.exception.error.NotFoundException;
import org.mercadolibre.NotNullTeam.mapper.BuyerMapper;
import org.mercadolibre.NotNullTeam.mapper.SellerMapper;
import org.mercadolibre.NotNullTeam.model.Buyer;
import org.mercadolibre.NotNullTeam.model.Seller;
import org.mercadolibre.NotNullTeam.repository.ISellerRepository;
import org.mercadolibre.NotNullTeam.service.ISellerService;
import org.mercadolibre.NotNullTeam.service.ISellerServiceInternal;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements ISellerService, ISellerServiceInternal {
    final ISellerRepository iSellerRepository;

    @Override
    public SellerFollowersCountDto getFollowersCount(Long id) {
        Seller seller = iSellerRepository.findById(id).orElseThrow(() -> new NotFoundException("Seller"));

        int followersCount = seller.quantityOfFollowers();

        return new SellerFollowersCountDto(seller.getUser().getId(), seller.getUser().getName(), followersCount);
    }

    @Override
    public Seller findById(Long id){
        return findSellerById(id, "Seller");
    }
  
    @Override
    public SellerResponseDTO getListFollowers(Long userId) {
        Seller seller = findSellerById(userId, "Seller");

        return SellerMapper.toSellerResponseDTO(seller, BuyerMapper.toListBuyerResponseWithNotSellerListDTO(seller.getFollowersList()));
    }

    @Override
    public SellerResponseDTO getListFollowersOrdered(Long userId, String order) {
        Seller seller = findSellerById(userId, "No se encontro el vendedor con ID = " + userId);

        List<Buyer> followersList = seller.getFollowersList();

        if (order.equals("name_asc")) {
            followersList.sort(Comparator.comparing(Buyer::getUsername));
        } else if (order.equals("name_desc")) {
            followersList.sort(Comparator.comparing(Buyer::getUsername).reversed());
        }

        return SellerMapper.toSellerResponseDTO(seller, BuyerMapper.toListBuyerResponseWithNotSellerListDTO(seller.getFollowersList()));
    }

    private Seller findSellerById(Long id, String message){
        return iSellerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(message));
    }
}
