package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.service.implementations;

import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.repository.IWarehouseRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.service.IWarehouseService;
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
