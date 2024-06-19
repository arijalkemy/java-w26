package com.mercadolibre.pf_be_hisp_w26_t01_coro.service;

import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.ResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.WarehouseRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.WarehouseResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.WarehouseStockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.Batch;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.User;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.repository.IWarehouseRepository;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.service.interfaces.*;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.util.UserMapper;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.util.WarehouseMapper;
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

    private final IUserServiceInternal userServiceInternal;

    private final IRoleServiceInternal roleServiceInternal;

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
    /**
     * Creates a new warehouse and asociate this to a manager, if manager doesn't exist, it will be created.
     * @param warehouseRequestDTO The warehouse data.
     * @return The DTO with msg of created warehouse
     */
    @Override
    public ResponseDto createWarehouse(WarehouseRequestDTO warehouseRequestDTO) {
        User manager = userServiceInternal.searchByEmailOrNUll(warehouseRequestDTO.getManager().getEmail());
        if(manager == null){
            manager = UserMapper.mapToUser(warehouseRequestDTO.getManager());
            manager.setRole(roleServiceInternal.searchById(2));
            userServiceInternal.saveUser(manager);
        }
          Warehouse warehouse = WarehouseMapper.toWarehouseWithManager(warehouseRequestDTO, manager);
         warehouseRepository.save(warehouse);
            return  new ResponseDto("Warehouse created successfully");
    }
}
