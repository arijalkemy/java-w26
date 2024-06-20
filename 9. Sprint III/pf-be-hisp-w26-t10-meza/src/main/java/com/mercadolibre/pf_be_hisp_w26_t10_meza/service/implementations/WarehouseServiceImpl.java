package com.mercadolibre.pf_be_hisp_w26_t10_meza.service.implementations;

import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.warehouse.WarehouseInfoDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.warehouse.WarehouseResponseInfoDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.warehouse.WarehouseResponseRegisterDto;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.Rol;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.UserAccount;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.exceptions.NoAccessException;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.repository.IUserAccountRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.repository.IWarehouseRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.service.IWarehouseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WarehouseServiceImpl implements IWarehouseService {

    @Autowired
    private IWarehouseRepository warehouseRepository;

    @Autowired
    private IUserAccountRepository userAccountRepository;
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
    public WarehouseResponseInfoDto findOneWarehouse(Integer id) {
        Optional<Warehouse> warehouse = warehouseRepository.findById(id);

        if (warehouse.isPresent()) {
            WarehouseResponseInfoDto responseInfoDto = new WarehouseResponseInfoDto();
            responseInfoDto.setId(warehouse.get().getId());
            responseInfoDto.setName(warehouse.get().getName());
            return responseInfoDto;
        }else {
            throw new NotFoundException("Warehouse not found");
        }
    }

    @Override
    public WarehouseResponseRegisterDto registerWarehouse(WarehouseInfoDto warehouseInfoDto) {

        //Verify if the user exist in db
        Optional<UserAccount> posibleUser = userAccountRepository.findById(warehouseInfoDto.getSupervisorId());

        if (!posibleUser.isPresent()) {
            throw new NotFoundException("There is no user with the id : " + warehouseInfoDto.getSupervisorId());
        }

        // Verify if the user is a SUPERVISOR

        Rol rolUser = posibleUser.get().getUserRole();
        if (!(rolUser == Rol.SUPERVISOR)){
            throw new NoAccessException("The user with id " + warehouseInfoDto.getSupervisorId() + " is not a SUPERVISOR.");
        }

        Warehouse newWarhouseInDB = new Warehouse();

        newWarhouseInDB.setName(warehouseInfoDto.getWarehouseName());
        newWarhouseInDB.setSupervisor(posibleUser.get());

        warehouseRepository.save(newWarhouseInDB);

        WarehouseResponseRegisterDto responseRegisterDto = new WarehouseResponseRegisterDto();

        responseRegisterDto.setMessage("Warehouse register successfully");
        return responseRegisterDto;
    }
}
