package com.meli.be_java_hisp_w26_g10.repository;

import com.api.socialmeli.entity.Buyer;
import com.api.socialmeli.entity.Seller;
import com.api.socialmeli.repository.impl.BuyerRepositoryImpl;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.meli.be_java_hisp_w26_g10.util.TestGeneratorUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BuyerRepositoryTest {

    BuyerRepositoryImpl buyerRepository = new BuyerRepositoryImpl();

    @Test
    @DisplayName("Obtener un usuario que existe ")
    public void getAnExistingUser(){
        //Act && Arrange
        Buyer buyerObtained = buyerRepository.getById(1);
        //Assert
        Assertions.assertNotNull(buyerObtained);
    }

    @Test
    @DisplayName("Obtener un usuario que no existe ")
    public void getANonExistingUser(){
        //Act && Arrange
        Buyer buyerObtained = buyerRepository.getById(100);
        //Assert
        Assertions.assertNull(buyerObtained);
    }

    @Test
    @DisplayName("Obtener todos los usuarios")
    public void getAllBuyers(){
        //Act && Arrange
        List<Buyer> buyers = buyerRepository.getAll();
        //Assert
        Assertions.assertEquals(buyers.size(), 10);
    }

    @Test
    @DisplayName("Seguir a un usuario")
    public void followUserTest(){
        //Act && Arrange
        Buyer buyer = TestGeneratorUtil.getSingleBuyer();
        Seller seller = new Seller(2, "Fernando");
        //Assert
        buyerRepository.followUser(buyer, seller);
        Assertions.assertEquals(buyer.getFollowed().get(1),seller);
    }
}
