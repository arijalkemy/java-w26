package com.mercadolibre.sprint_3_team_12.repository;

import com.mercadolibre.sprint_3_team_12.entity.UserProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserProductRepository extends JpaRepository<UserProduct, Long> {
    @Query("SELECT up FROM UserProduct up " +
            "JOIN up.product p " +
            "JOIN up.user u " +
            "WHERE p.name = :productName " +
            "AND u.id = :userId")
    UserProduct findByProductNameAndUserId(@Param("productName") String productName, @Param("userId") Long userId);

}
