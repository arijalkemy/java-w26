package org.mercadolibre.NotNullTeam.service.impl;

import lombok.RequiredArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.response.BuyerResponseWithNotSellerListDTO;
import org.mercadolibre.NotNullTeam.DTO.response.SellerFollowersCountDto;
import org.mercadolibre.NotNullTeam.DTO.response.SellerResponseDTO;
import org.mercadolibre.NotNullTeam.exception.error.NotFoundException;
import org.mercadolibre.NotNullTeam.model.Buyer;
import org.mercadolibre.NotNullTeam.model.Seller;
import org.mercadolibre.NotNullTeam.repository.ISellerRepository;
import org.mercadolibre.NotNullTeam.service.IBuyerService;
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
        return iSellerRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Seller"));
    }
  
    @Override
    public SellerResponseDTO getListFollowers(Long userId) {
        Seller seller = iSellerRepository
                .findById(userId)
                .orElseThrow(() -> new NotFoundException("Seller"));

        return new SellerResponseDTO(
                seller.getUser().getId(),
                seller.getUser().getName(),
                seller.getFollowersList().stream().map(
                        s -> new BuyerResponseWithNotSellerListDTO(
                                s.getUser().getId(),s.getUser().getName())).toList());
    }

    @Override
    public SellerResponseDTO getListFollowersOrdered(Long userId, String order) {
        Seller seller = iSellerRepository
                .findById(userId)
                .orElseThrow(() -> new NotFoundException("No se encontro el vendedor con ID = " + userId));

        List<Buyer> followersList = seller.getFollowersList();

        if (order.equals("name_asc")) {
            followersList.sort(Comparator.comparing(Buyer::getUsername));
        } else if (order.equals("name_desc")) {
            followersList.sort(Comparator.comparing(Buyer::getUsername).reversed());
        }

        return new SellerResponseDTO(
                seller.getUser().getId(),
                seller.getUsername(),
                followersList.stream().map(
                        x -> new BuyerResponseWithNotSellerListDTO(
                                x.getUser().getId(),
                                x.getUsername()
                        )
                ).toList()
        );
    }
}
