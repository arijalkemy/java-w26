package com.mercadolibre.final_project_java_h_w26_t10.service.implementations;

import com.mercadolibre.final_project_java_h_w26_t10.entity.Warehouse;
import com.mercadolibre.final_project_java_h_w26_t10.exceptions.NotFoundException;
import com.mercadolibre.final_project_java_h_w26_t10.repository.IWarehouseRepository;
import com.mercadolibre.final_project_java_h_w26_t10.service.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WarehouseServiceImpl implements IWarehouseService {

    @Autowired
    private IWarehouseRepository warehouseRepository;

    @Override
    public Warehouse findById(Integer id) {
        Optional<Warehouse> warehouse = warehouseRepository.findById(id);

        if (warehouse.isPresent()) {
            return warehouse.get();
        }else {
            throw new NotFoundException("Warehouse not found");
        }
    }

}
