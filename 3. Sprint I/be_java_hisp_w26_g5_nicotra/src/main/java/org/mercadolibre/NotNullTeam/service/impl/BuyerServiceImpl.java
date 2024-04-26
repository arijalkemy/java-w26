package org.mercadolibre.NotNullTeam.service.impl;

import lombok.RequiredArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.response.BuyerResponseDTO;
import org.mercadolibre.NotNullTeam.DTO.response.BuyerResponseWithNotSellerListDTO;
import org.mercadolibre.NotNullTeam.exception.error.NotFoundException;
import org.mercadolibre.NotNullTeam.exception.error.UserAlreadyFollowedException;
import org.mercadolibre.NotNullTeam.mapper.BuyerMapper;
import org.mercadolibre.NotNullTeam.mapper.SellerMapper;
import org.mercadolibre.NotNullTeam.model.Buyer;
import org.mercadolibre.NotNullTeam.model.Seller;
import org.mercadolibre.NotNullTeam.repository.IBuyerRepository;
import org.mercadolibre.NotNullTeam.repository.ISellerRepository;
import org.mercadolibre.NotNullTeam.service.IBuyerService;
import org.mercadolibre.NotNullTeam.service.ISellerServiceInternal;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BuyerServiceImpl implements IBuyerService {
    final IBuyerRepository iBuyerRepository;
    final ISellerRepository iSellerRepository;
    final ISellerServiceInternal iSellerService;

    @Override
    public void followSeller(Long userId, Long sellerToFollowId) {

        Buyer buyer = this.findBuyerById(userId);
        Seller seller =iSellerService.findById(sellerToFollowId);

        if(buyer.getFollowedList().stream().anyMatch(s -> s.getUser().getId().equals(sellerToFollowId))){
            throw new UserAlreadyFollowedException();
        }

        buyer.addNewFollowed(seller);
        seller.addNewFollower(buyer);

        updateRepositories(buyer, seller);
    }

    private void updateRepositories(Buyer buyer, Seller seller){
        iBuyerRepository.update(buyer);
        iSellerRepository.update(seller);
    }

    @Override
    public List<BuyerResponseWithNotSellerListDTO> getAll() {
        return iBuyerRepository
                .findAll()
                .stream()
                .map(e -> new BuyerResponseWithNotSellerListDTO(e.getUser().getId(), e.getUser().getName())).toList();
    }

    @Override
    public BuyerResponseDTO getFollowedListOrdered(Long userId, String order) {
        Buyer buyer =
                this.findBuyerById(userId);

        List<Seller> followedList = buyer.getFollowedList();

        if (order.equals("name_asc")) {
            followedList.sort(Comparator.comparing(Seller::getUsername));
        } else if (order.equals("name_desc")) {
            followedList.sort(Comparator.comparing(Seller::getUsername).reversed());
        }

        return BuyerMapper.toBuyerResponseDTO(buyer,
                  SellerMapper.toListSellerResponseWithNotBuyerListDTO(followedList));
    }


    public void unfollowSeller(Long userId, Long userIdToUnfollow) {
        Buyer buyer = this.findBuyerById(userId);
        Seller seller = iSellerService.findById(userIdToUnfollow);

        buyer.removeFollowed(seller);
        seller.removeFollower(buyer);

        updateRepositories(buyer, seller);
    }

    public Buyer findBuyerById(Long id){
        return iBuyerRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Buyer"));
    }

}
