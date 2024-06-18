package com.mercadolibre.sprint_3_team_12.repository;

import com.mercadolibre.sprint_3_team_12.entity.InboundOrder;
import com.mercadolibre.sprint_3_team_12.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IInboundOrderRepository extends JpaRepository<InboundOrder, Long> {
    Optional<InboundOrder> findByOrderNumberAndUser(Long orderNumber, User user);
}
