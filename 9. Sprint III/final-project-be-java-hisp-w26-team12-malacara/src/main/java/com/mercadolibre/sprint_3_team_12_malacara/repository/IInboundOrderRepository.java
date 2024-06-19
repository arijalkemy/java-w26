package com.mercadolibre.sprint_3_team_12_malacara.repository;

import com.mercadolibre.sprint_3_team_12_malacara.entity.InboundOrder;
import com.mercadolibre.sprint_3_team_12_malacara.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IInboundOrderRepository extends JpaRepository<InboundOrder, Long> {
    Optional<InboundOrder> findByOrderNumberAndUser(Long orderNumber, User user);
}
