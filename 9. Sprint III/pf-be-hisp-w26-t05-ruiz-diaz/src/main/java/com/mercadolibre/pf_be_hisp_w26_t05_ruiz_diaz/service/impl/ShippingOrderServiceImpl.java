package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.impl;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request.ShippingOrderChangeStateRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response.ShippingOrderResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.enums.ShippingOrderState;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.exceptions.error.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.mapper.ShippingOrderMapper;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.*;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.repository.interfaces.IShippingOrderRepository;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.repository.interfaces.IWarehouseRepository;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces.IDistanceService;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces.IPurchaseOrderServiceInternal;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces.IShippingOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShippingOrderServiceImpl implements IShippingOrderService {

    final IShippingOrderRepository shippingOrderRepository;
    final IWarehouseRepository warehouseRepository;
    final IDistanceService distanceService;
    final IPurchaseOrderServiceInternal purchaseOrderServiceInternal;

    @Override
    @Transactional
    public ShippingOrderResponseDTO generateShippingOrder(Integer idPurchaseOrder) {

        ShippingOrder shippingOrder = new ShippingOrder();
        PurchaseOrder purchaseOrder = purchaseOrderServiceInternal.findPurchaseOrderById(idPurchaseOrder);

        Warehouse warehouse = getNearestWarehouseFromBuyer(purchaseOrder.getBuyer());

        shippingOrder.setPurchaseOrder(purchaseOrder);
        shippingOrder.setBuyerLocation(purchaseOrder.getBuyer().getLocation());
        shippingOrder.setSourceWarehouse(warehouse);
        shippingOrder.setDateCreated(LocalDate.now());
        shippingOrder.setDateUpdated(LocalDate.now());
        shippingOrder.setState(ShippingOrderState.PENDING);

        shippingOrderRepository.save(shippingOrder);

        return ShippingOrderMapper.toResponseDTO(shippingOrder);
    }

    @Override
    @Transactional
    public List<ShippingOrderResponseDTO> getShippingOrdersPending() {
        return shippingOrderRepository.findByState(ShippingOrderState.PENDING).stream()
                .map(ShippingOrderMapper::toResponseDTO)
                .toList();
    }

    @Override
    @Transactional
    public ShippingOrderResponseDTO updateStateShippingOrder(Integer idPurchaseOrder, ShippingOrderChangeStateRequestDTO stateDTO) {

        ShippingOrder shippingOrder = shippingOrderRepository.findById(idPurchaseOrder)
                .orElseThrow(() -> new NotFoundException("Shipping order with id " + idPurchaseOrder));

        shippingOrder.setState(ShippingOrderState.valueOf(stateDTO.getState()));

        shippingOrder.setDateUpdated(LocalDate.now());

        shippingOrderRepository.save(shippingOrder);

        return ShippingOrderMapper.toResponseDTO(shippingOrder);
    }

    @Override
    @Transactional
    public ShippingOrderResponseDTO getShippingOrderById(Integer idPurchaseOrder) {

        return this.shippingOrderRepository.findById(idPurchaseOrder)
                .map(ShippingOrderMapper::toResponseDTO)
                .orElseThrow(() -> new NotFoundException("Shipping order with id " + idPurchaseOrder));
    }

    private Warehouse getNearestWarehouseFromBuyer(UserEntity buyer) {
        List<Warehouse> warehouses = warehouseRepository.findAll();
        Location buyerLocation = buyer.getLocation();

        Optional<Warehouse> nearestWarehouse =  warehouses.stream().min(
                Comparator.comparing(
                        warehouse -> distanceService.getDistanceBetweenTwoLocations(
                                buyerLocation,
                                warehouse.getLocation()
                        )
                )
        );

        return nearestWarehouse.orElseThrow(() -> new NotFoundException("Warehouse nearest to buyer not found"));
    }
}
