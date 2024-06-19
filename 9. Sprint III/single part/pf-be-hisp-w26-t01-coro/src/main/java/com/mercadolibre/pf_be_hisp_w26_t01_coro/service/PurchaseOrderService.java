package com.mercadolibre.pf_be_hisp_w26_t01_coro.service;

import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.ProductPurchaseResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.PurchaseOrderDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.PurchaseTotalPriceDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.PurchaseOrder;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.User;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.enums.OrderStatus;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.repository.IPurchaseOrderRepository;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.service.interfaces.IBatchService;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.service.interfaces.IPurchaseOrderService;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.service.interfaces.IUserService;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.util.ProductMapper;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.util.PurchaseOrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseOrderService implements IPurchaseOrderService {

    private final IPurchaseOrderRepository purchaseOrderRepository;
    private final IBatchService batchService;
    private final IUserService userService;
    @Override
    @Transactional
    public PurchaseTotalPriceDTO calculatePurchaseTotalPrice(PurchaseOrderDTO purchaseOrderDTO) {
        User buyer = userService.searchUserById(purchaseOrderDTO.getBuyer_id());
        Double totalPrice = batchService.checkProductStock(purchaseOrderDTO.getProducts());
        purchaseOrderRepository.save(PurchaseOrderMapper.PurcharOrderMappingFromDto(purchaseOrderDTO,buyer));
        return PurchaseTotalPriceDTO
                .builder()
                .total_price(totalPrice)
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductPurchaseResponseDto> searchAllProductsByOrder(Integer idOrder) {
        PurchaseOrder purchaseOrder = purchaseOrderRepository
                .findPurchaseOrderById(idOrder)
                .orElseThrow(() -> new ApiException("Not Found","No se encontró la orden id: " + idOrder,404));
        return purchaseOrder
                .getOrderItems()
                .stream()
                .map(o -> ProductMapper
                        .productPurchaseResponseDtoMappingFromProduct(o.getProduct(),
                                                                        o.getQuantity()))
                .toList();
    }

    @Override
    public void modifyOrder(Integer id, PurchaseOrderDTO orderDTO) {
        if(!orderDTO.getOrder_status().getStatus_code().equals(OrderStatus.CARRITO.name())){
            throw new ApiException("Invalid Arguments",
                    "No se puede modificar una orden en un estado que no sea " + OrderStatus.CARRITO.name(),
                    400);
        }
        User buyer = userService.searchUserById(orderDTO.getBuyer_id());
        purchaseOrderRepository.save(PurchaseOrderMapper.newPurcharOrderMappingFromDto(id,orderDTO,buyer));
    }
}
