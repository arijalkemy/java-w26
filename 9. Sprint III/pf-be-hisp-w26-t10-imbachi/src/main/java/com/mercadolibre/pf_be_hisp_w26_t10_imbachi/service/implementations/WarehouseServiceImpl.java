package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.service.implementations;

import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.WarehouseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.repository.IWarehouseRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.service.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public List<WarehouseDto> getWhBySupervisor(Long supervisor_id) {
        List<Warehouse> warehouseResponse = warehouseRepository.findBySupervisorId(supervisor_id);
        if(warehouseResponse.isEmpty()) {
            throw new NotFoundException("No hay warehouses que sean supervisadas por este supervisor");
        }
        return warehouseResponse.stream().map(w -> new WarehouseDto(
                w.getId(),
                w.getName()
        )).toList();
    }

}
