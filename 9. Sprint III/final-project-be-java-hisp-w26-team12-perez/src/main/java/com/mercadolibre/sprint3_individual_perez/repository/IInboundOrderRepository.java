package com.mercadolibre.sprint3_individual_perez.repository;

import com.mercadolibre.sprint3_individual_perez.entity.InboundOrder;
import com.mercadolibre.sprint3_individual_perez.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IInboundOrderRepository extends JpaRepository<InboundOrder, Long> {
    Optional<InboundOrder> findByOrderNumberAndUser(Long orderNumber, User user);

    Optional<List<InboundOrder>> getInboundOrdersByUserId(Long id);
}
