package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.unit.service;

import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.Batch;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.Sector;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.repository.ISectorRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.service.implementations.SectorServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.util.EntitiesUtilsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

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

    @DisplayName("No batches found in sector")
    @Test
    public void noBatchesFoundInSector() {

        Product product = EntitiesUtilsTest.mazanaProduct();
        Warehouse warehouse = EntitiesUtilsTest.warehouse();
        Sector sector = new Sector(); // Crear un sector sin lotes
        Set<Batch> batches = Collections.EMPTY_SET;
        sector.setBatches(batches); //
        Optional<Sector> optionalSector = Optional.of(sector);

        when(sectorRepository.findByCategoryAndWarehouse(product.getCategory(), warehouse)).thenReturn(optionalSector);

        Assertions.assertThrows(NotFoundException.class, () -> sectorService.searchSectorByCategoryAndWorehouse(product.getCategory(), warehouse));

    }

}
