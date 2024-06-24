package com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.TransferService;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.OutboundOrderDto.OutboundOrderDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.OutboundOrderDto.OutboundOrderRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

public interface ITransferService {
    void initiateTransfer(OutboundOrderDto outboundOrderDto);
    void updateTransferStatus(Long orderNumber, String newStatus);
}
