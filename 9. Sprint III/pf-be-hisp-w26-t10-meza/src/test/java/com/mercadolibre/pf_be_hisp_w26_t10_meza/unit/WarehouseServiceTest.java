package com.mercadolibre.pf_be_hisp_w26_t10_meza.unit;

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
import com.mercadolibre.pf_be_hisp_w26_t10_meza.service.implementations.WarehouseServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class WarehouseServiceTest {

    @Mock
    private IWarehouseRepository warehouseRepository;

    @Mock
    private IUserAccountRepository userAccountRepository;

    @InjectMocks
    WarehouseServiceImpl warehouseService;

    @Test
    @DisplayName("Test US 6 - Getting one warehouse successfully")
    public void getOneWarehouse () {

        Integer id = 1;
        WarehouseResponseInfoDto warehouseResponseInfoDto = new WarehouseResponseInfoDto();

        warehouseResponseInfoDto.setName("Almacén Principal");
        warehouseResponseInfoDto.setId(1);


        Warehouse myWarehouse = new Warehouse();
        myWarehouse.setName("Almacén Principal");
        myWarehouse.setId(1);
        Optional<Warehouse> warehouse = Optional.of(myWarehouse);
        when(warehouseRepository.findById(id)).thenReturn(warehouse);

        WarehouseResponseInfoDto responseObtained = warehouseService.findOneWarehouse(id);

        Assertions.assertEquals(warehouseResponseInfoDto, responseObtained);


    }

    @Test
    @DisplayName("Test US 6 - NotFoundException thrown because of not warehouse found")
    public void getOneWarehouseThrowingNotFoundException () {

        Integer id = 1;

        Optional<Warehouse> warehouse = Optional.empty();
        when(warehouseRepository.findById(id)).thenReturn(warehouse);

        Assertions.assertThrows(NotFoundException.class, () -> warehouseService.findOneWarehouse(id));



    }

    @Test
    @DisplayName("Test US 6 - Registration of a warehouse successfully")
    public void registerAWarehouse () {

        WarehouseInfoDto warehouseInfoDto = new WarehouseInfoDto();
        warehouseInfoDto.setWarehouseName("NuevaHouse");
        warehouseInfoDto.setSupervisorId(9L);

        WarehouseResponseRegisterDto warehouseResponseRegisterDto = new WarehouseResponseRegisterDto();
        warehouseResponseRegisterDto.setMessage("Warehouse register successfully");

        UserAccount userAccount = new UserAccount();
        userAccount.setUserId(9L);
        userAccount.setUserRole(Rol.SUPERVISOR);
        Optional<UserAccount> posibleUser = Optional.of(userAccount);

        when(userAccountRepository.findById(warehouseInfoDto.getSupervisorId())).thenReturn(posibleUser);

        WarehouseResponseRegisterDto responseObtained = warehouseService.registerWarehouse(warehouseInfoDto);

        Assertions.assertEquals(warehouseResponseRegisterDto, responseObtained);

    }

    @Test
    @DisplayName("Test US 6 - NotFoundException thrownd because of no existing user")
    public void noUserExist () {

        WarehouseInfoDto warehouseInfoDto = new WarehouseInfoDto();

        UserAccount userAccount = new UserAccount();
        userAccount.setUserId(9L);
        userAccount.setUserRole(Rol.SUPERVISOR);
        Optional<UserAccount> posibleUser = Optional.empty();

        when(userAccountRepository.findById(warehouseInfoDto.getSupervisorId())).thenReturn(posibleUser);

        Assertions.assertThrows(NotFoundException.class, () -> warehouseService.registerWarehouse(warehouseInfoDto));

    }

    @Test
    @DisplayName("Test US 6 - NoAccessException thrownd because the user has no role of SUPERVISOR")
    public void userIsNotSupervisor () {

        WarehouseInfoDto warehouseInfoDto = new WarehouseInfoDto();

        UserAccount userAccount = new UserAccount();
        userAccount.setUserId(9L);
        userAccount.setUserRole(Rol.BUYER);
        Optional<UserAccount> posibleUser = Optional.of(userAccount);

        when(userAccountRepository.findById(warehouseInfoDto.getSupervisorId())).thenReturn(posibleUser);

        Assertions.assertThrows(NoAccessException.class, () -> warehouseService.registerWarehouse(warehouseInfoDto));

    }

}
