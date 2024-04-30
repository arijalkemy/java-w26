package org.mercadolibre.NotNullTeam.bootstrap;

import org.mercadolibre.NotNullTeam.DTO.request.ProductDTO;
import org.mercadolibre.NotNullTeam.DTO.request.PromoPostDTO;
import org.mercadolibre.NotNullTeam.model.*;
import org.mercadolibre.NotNullTeam.repository.IBuyerRepository;
import org.mercadolibre.NotNullTeam.repository.ISellerRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Bootstrap implements InitializingBean {

    @Autowired
    private IBuyerRepository buyerRepository;

    @Autowired
    private ISellerRepository sellerRepository;

    @Override
    public void afterPropertiesSet() {
        User userOne = new User(1L, "Juan Perez");
        User userTwo = new User(2L, "Maria Lopez");
        User userThree = new User(3L, "Carlos Tevez");
        User userFour = new User(4L, "Agustin Diaz");
        User userFive = new User(5L, "Bernardo Thomas");

        ArrayList<PromoPost> productOne = new ArrayList<>();
        productOne.add(new PromoPost(1L, "2024-04-25", new ProductDTO(2L,"name","type", "brand","color","notes"), 1, 10.0, true, 2.0));
        productOne.add(new PromoPost(2L, "2024-04-26", new ProductDTO(3L, "nombre2", "tipo2", "marca2", "color2", "notas2"), 2, 15.0, false, 0.0));
        productOne.add(new PromoPost(3L, "2024-04-27", new ProductDTO(4L, "nombre3", "tipo3", "marca3", "color3", "notas3"), 1, 20.0, true, 3.0));


        Buyer buyerOne = new Buyer(userOne, new ArrayList<>());
        Buyer buyerTwo = new Buyer(userTwo, new ArrayList<>());
        Seller sellerOne = new Seller(userThree,  new ArrayList<>(List.of(buyerOne, buyerTwo)),productOne);
        Seller sellerTwo = new Seller(userFour,  new ArrayList<>(List.of(buyerOne, buyerTwo)),productOne);
        Seller sellerThree = new Seller(userFive,  new ArrayList<>(List.of(buyerOne, buyerTwo)),productOne);

        buyerOne.addNewFollowed(sellerOne);
        buyerOne.addNewFollowed(sellerTwo);
        buyerOne.addNewFollowed(sellerThree);
        buyerTwo.addNewFollowed(sellerOne);

        buyerRepository.save(buyerOne);
        buyerRepository.save(buyerTwo);

        sellerRepository.save(sellerOne);
        sellerRepository.save(sellerTwo);
        sellerRepository.save(sellerThree);
    }
}
