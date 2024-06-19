package com.mercadolibre.pf_be_hisp_w26_t10_hoyos.unit.service;

import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.entity.Sector;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.entity.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.repository.ISectorRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.service.implementations.SectorServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.util.EntitiesUtilsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SectorServiceTest {

    @Mock
    private ISectorRepository sectorRepository;

    @InjectMocks
    private SectorServiceImpl sectorService;


    @DisplayName("Sector Warehouse not found")
    @Test
    public void sectorNotFound() {

        Product product = EntitiesUtilsTest.mazanaProduct();
        Warehouse warehouse = EntitiesUtilsTest.warehouse();
        Optional<Sector> sector = Optional.empty();

        when(sectorRepository.findByCategoryAndWarehouse(product.getCategory(),warehouse)).thenReturn(sector);

        Assertions.assertThrows(NotFoundException.class, () -> sectorService.searchSectorByCategoryAndWorehouse(product.getCategory(), warehouse));

    }

}
