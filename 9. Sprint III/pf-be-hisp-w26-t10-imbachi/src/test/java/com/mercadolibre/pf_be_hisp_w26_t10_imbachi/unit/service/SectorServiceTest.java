package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.unit.service;

import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Sector;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.repository.ISectorRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.service.implementations.SectorServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.util.EntitiesUtilsTest;
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
