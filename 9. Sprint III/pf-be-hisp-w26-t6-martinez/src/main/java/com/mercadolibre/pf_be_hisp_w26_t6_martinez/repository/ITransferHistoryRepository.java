package com.mercadolibre.pf_be_hisp_w26_t6_martinez.repository;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.OutboundOrder;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.TransferHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransferHistoryRepository extends JpaRepository<TransferHistory, Long> {

    List<TransferHistory> findAllByOrderNumber(OutboundOrder orderNumber);
}
