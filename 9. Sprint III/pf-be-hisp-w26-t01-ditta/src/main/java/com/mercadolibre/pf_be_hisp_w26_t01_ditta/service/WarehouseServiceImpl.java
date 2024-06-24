package com.mercadolibre.pf_be_hisp_w26_t01_ditta.service;

import com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos.WarehouseResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos.WarehouseStockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.entity.Batch;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.entity.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.repository.IWarehouseRepository;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces.IBatchServiceInternal;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces.IProductServiceInternal;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces.IWarehouseService;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces.IWarehouseServiceInternal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements IWarehouseServiceInternal, IWarehouseService {

    private final IWarehouseRepository warehouseRepository;
    private final IBatchServiceInternal batchServiceInternal;
    private final IProductServiceInternal productServiceInternal;

    @Override
    public Warehouse findWarehouseById(Integer warehouseId){
        return warehouseRepository.findById(warehouseId)
                .orElseThrow(() -> new ApiException("Not Found",
                        "No se encontró un warehouse con id: " + warehouseId,
                        404));
    }

    @Override
    public List<Warehouse> findAllWarehouses(){
        List<Warehouse> allWarehouses= warehouseRepository.findAll();
        if(allWarehouses.isEmpty()) {
            throw new ApiException("Not Found",
                    "No se encontraron warehouses",
                    404);
        }
        return allWarehouses;
    }

    private List<WarehouseResponseDTO> batchesGroupedByWharehouse(Integer productId){
        List<Warehouse> warehouses= findAllWarehouses();
        List<Batch> allBatches= batchServiceInternal.findAllByProductIdAndQuantityGreatherThanCero(productId);
        List<WarehouseResponseDTO> warehouseResponseDTOList= new ArrayList<>();
        for(Warehouse warehouse:warehouses){
            List<Batch> batchesFiltered= allBatches.stream()
                    .filter(b-> b.getInboundOrder().getSection().getWarehouse().getId().equals(warehouse.getId()))
                    .toList();
            WarehouseResponseDTO warehouseResponseDTO= WarehouseResponseDTO.builder()
                            .warehouse_code(warehouse.getId())
                            .total_quantity(batchesFiltered.stream()
                                            .mapToInt(Batch::getCurrentQuantity)
                                            .sum())
                            .build();
            warehouseResponseDTOList.add(warehouseResponseDTO);
        }
        return warehouseResponseDTOList;
    }

    public WarehouseStockResponseDTO findStockWarehouseByProductId(Integer productId){
        productServiceInternal.findById(productId);
        return WarehouseStockResponseDTO.builder()
                .product_id(productId)
                .warehouses(batchesGroupedByWharehouse(productId))
                .build();
    }


}
