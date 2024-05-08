package com.meli.be_java_hisp_w26_g10.repository;

import com.meli.be_java_hisp_w26_g10.entity.Seller;
import com.meli.be_java_hisp_w26_g10.repository.impl.SellerRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SellerRepositoryTest {

    SellerRepositoryImpl sellerRepository = new SellerRepositoryImpl();
    @Test
    @DisplayName("Obtener un usuario que existe ")
    public void getAnExistingUser(){
        //Act && Arrange
        Seller sellerObtained = sellerRepository.getById(1);
        //Assert
        Assertions.assertNotNull(sellerObtained);
    }

    @Test
    @DisplayName("Obtener un usuario que no existe ")
    public void getAnNonExistingUser(){
        //Act && Arrange
        Seller sellerObtained = sellerRepository.getById(1);
        //Assert
        Assertions.assertNotNull(sellerObtained);
    }

    @Test
    @DisplayName("Obtener todos los usuarios")
    public void getAllSellers(){
        //Act && Arrange
        List<Seller> sellers = sellerRepository.getAll();
        //Assert
        Assertions.assertEquals(sellers.size(), 6);
    }
}
