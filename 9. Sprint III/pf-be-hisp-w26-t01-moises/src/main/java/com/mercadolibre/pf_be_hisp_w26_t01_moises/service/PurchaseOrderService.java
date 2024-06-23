package com.mercadolibre.pf_be_hisp_w26_t01_moises.service;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.ProductPurchaseResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.PurchaseOrderDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.PurchaseOrderResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.PurchaseTotalPriceDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.entity.PurchaseOrder;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.entity.User;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.enums.OrderStatus;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.enums.PurchaseOrderSortingType;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.repository.IPurchaseOrderRepository;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.service.interfaces.IBatchService;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.service.interfaces.IPurchaseOrderService;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.service.interfaces.IUserServiceInternal;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.util.ProductMapper;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.util.PurchaseOrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PurchaseOrderService implements IPurchaseOrderService {

    private final IPurchaseOrderRepository purchaseOrderRepository;
    private final IBatchService batchService;
    private final IUserServiceInternal userService;

    @Override
    @Transactional
    public PurchaseTotalPriceDTO calculatePurchaseTotalPrice(PurchaseOrderDTO purchaseOrderDTO) {
        User buyer = userService.searchUserById(purchaseOrderDTO.getBuyerId());
        Double totalPrice = batchService.checkProductStock(purchaseOrderDTO.getProducts());
        purchaseOrderRepository.save(PurchaseOrderMapper.PurcharOrderMappingFromDto(purchaseOrderDTO, buyer));
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
                .orElseThrow(() -> new ApiException("Not Found", "No se encontró la orden id: " + idOrder, 404));
        return purchaseOrder
                .getOrderItems()
                .stream()
                .map(o -> ProductMapper
                        .mapToProductPurchaseResponseDto(o.getProduct(),
                                o.getQuantity()))
                .toList();
    }

    @Override
    public void modifyOrder(Integer id, PurchaseOrderDTO orderDTO) {
        if (!orderDTO.getOrder_status().getStatus_code().equals(OrderStatus.CARRITO.name())) {
            throw new ApiException("Invalid Arguments",
                    "No se puede modificar una orden en un estado que no sea " + OrderStatus.CARRITO.name(),
                    400);
        }
        User buyer = userService.searchUserById(orderDTO.getBuyerId());
        purchaseOrderRepository.save(PurchaseOrderMapper.newPurcharOrderMappingFromDto(id, orderDTO, buyer));
    }

    private List<PurchaseOrderResponseDTO> getAllByBuyerEmail(String buyerEmail) {
        User buyer = userService.searchByEmail(buyerEmail);
        List<PurchaseOrder> orders = purchaseOrderRepository.findAllByUser_Id(buyer.getId());
        if (orders.isEmpty()) {
            throw new ApiException("Not found", "No se encontraron ordenes pertenecientes al comprador", 404);
        }
        return orders.stream()
                .map(PurchaseOrderMapper::mapToResponseDto)
                .toList();
    }

    @Override
    @Transactional
    public List<PurchaseOrderResponseDTO> getAllByBuyerEmailSorted(String buyerEmail,
                                                                   Optional<PurchaseOrderSortingType> sortingType) {
        List<PurchaseOrderResponseDTO> result = getAllByBuyerEmail(buyerEmail);
        if (sortingType.isEmpty()) {
            return result;
        }
        if (sortingType.get().equals(PurchaseOrderSortingType.date)) {
            return sortPurchaseOrdersByDate(result);
        }
        return sortPurchaseOrdersByTotalPrice(result);
    }

    private List<PurchaseOrderResponseDTO> sortPurchaseOrdersByDate(List<PurchaseOrderResponseDTO> orders) {
        return orders.stream()
                .sorted(Comparator.comparing(PurchaseOrderResponseDTO::getDate))
                .toList();
    }

    private List<PurchaseOrderResponseDTO> sortPurchaseOrdersByTotalPrice(List<PurchaseOrderResponseDTO> orders) {
        return orders.stream()
                .sorted(Comparator.comparing(PurchaseOrderResponseDTO::getTotalPrice))
                .toList();
    }


}
