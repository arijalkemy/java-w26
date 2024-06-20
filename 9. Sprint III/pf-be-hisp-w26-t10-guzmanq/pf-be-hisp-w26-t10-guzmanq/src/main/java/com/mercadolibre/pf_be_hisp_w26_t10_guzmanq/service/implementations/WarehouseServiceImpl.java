package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.service.implementations;

import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.ShoppingCart;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.repository.IInboundOrderRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.repository.IWarehouseRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.service.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseServiceImpl implements IWarehouseService {

    @Autowired
    private IWarehouseRepository warehouseRepository;
    private IInboundOrderRepository orderRepository;

    @Override
    public Warehouse findById(Integer id) {
        Optional<Warehouse> warehouse = warehouseRepository.findById(id);

        if (warehouse.isPresent()) {
            return warehouse.get();
        }else {
            throw new NotFoundException("Warehouse not found");
        }
    }

//    @Override
//    public Double getCantInboundOrderForMonth(Integer idWarehouse) {
//        Double cantInboundOrder = orderRepository.getCantInboundOrderForMonth(idWarehouse);
//        if (cantInboundOrder == null)
//            throw new NotFoundException("data not found");
//        return cantInboundOrder;
//    }



}
