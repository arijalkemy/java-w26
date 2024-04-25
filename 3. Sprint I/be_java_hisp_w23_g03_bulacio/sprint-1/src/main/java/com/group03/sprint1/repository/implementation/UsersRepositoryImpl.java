package com.group03.sprint1.repository.implementation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.group03.sprint1.entity.Buyer;
import com.group03.sprint1.entity.Publication;
import com.group03.sprint1.entity.Seller;
import com.group03.sprint1.entity.UserData;
import com.group03.sprint1.repository.IUsersRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class UsersRepositoryImpl implements IUsersRepository {

    private List<Buyer> buyers;
    private List<Seller> sellers;
    private Integer counter = 0;

    public UsersRepositoryImpl() throws IOException {
        loadBuyers();
        loadSellers();
    }

    private void loadBuyers() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        List<Buyer> buyersList;

        file= ResourceUtils.getFile("classpath:buyer.json");
        buyersList= objectMapper.readValue(file,new TypeReference<List<Buyer>>(){});

        buyers = buyersList;
    }

    private void loadSellers() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        File file = ResourceUtils.getFile("classpath:seller.json");
        sellers = objectMapper.readValue(file, new TypeReference<List<Seller>>() {});
    }

    @Override
    public List<UserData> findBuyerSellersFollowedByUserId(Integer userId){
        Optional<Buyer> buyer = buyers.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst();

        if (buyer.isPresent()) {
            return buyer.get().getFollowed();
        }

        return null;
    }

    @Override
    public Seller findSellerById(Integer userId) {
        return sellers.stream().filter( s -> s.getUserId().equals(userId)).findFirst().orElse(null);
    }

    @Override
    public Buyer findBuyerById(Integer userId) {
        return buyers.stream().filter( b -> b.getUserId().equals(userId)).findFirst().orElse(null);
    }

    @Override
    public void follow(Seller seller, Buyer buyer) {
        addFollower(seller);
        addFollowed(buyer);
    }

    private void addFollower(Seller seller) {
        int indexSeller = sellers.indexOf(seller);
        sellers.set(indexSeller, seller);
    }

    private void addFollowed(Buyer buyer) {
        int indexBuyer = buyers.indexOf(buyer);
        buyers.set(indexBuyer, buyer);
    }

    @Override
    public List<Seller> findAllSellers() {
        return sellers;
    }

    @Override
    public Seller createPublication(Publication publication) {
        publication.setPostId(++counter);
        Seller seller = findSellerById(publication.getUserId());
        List<Publication> publications = seller.getPublications();
        publications.add(publication);
        seller.setPublications(publications);
        return seller;
    }

    public List<Buyer> showBuyers(){
        return buyers;
    }
    public List<Seller> showSellers(){
        return sellers;
    }

    @Override
    public void unfollow(Seller seller, Buyer buyer) {
        deleteFollower(seller, buyer);
        deleteFollowed(buyer, seller);
    }

    private void deleteFollower(Seller seller, Buyer buyer) {
        int indexSeller = sellers.indexOf(seller);
        sellers.set(indexSeller, seller);
    }

    private void deleteFollowed(Buyer buyer, Seller seller) {
        int indexBuyer = buyers.indexOf(buyer);
        buyers.set(indexBuyer, buyer);
    }
}
