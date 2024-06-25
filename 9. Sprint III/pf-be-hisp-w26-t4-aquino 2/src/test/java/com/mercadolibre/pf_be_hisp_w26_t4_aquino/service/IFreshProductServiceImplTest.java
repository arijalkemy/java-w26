package com.mercadolibre.pf_be_hisp_w26_t4_aquino.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.response.ProductLocationDto;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.model.User;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.model.projection.BatchWithLocation;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.repository.IBatchRepository;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.util.BatchOrder;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.utils.BatchWithLocationImpl;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class IFreshProductServiceImplTest {

    @Mock
    private IBatchRepository batchRepository;

    @InjectMocks
    private FreshProductServiceImpl service;

    @Test
    void getProductLocationsByType_orderByCurrentQuantity() {
        User user = new User();
        Long idProduct = 1L;
        List<BatchWithLocation> locations = getLocations();

        when(batchRepository.findByProductIdOrderByCurrentQuantity(user.getId(), idProduct))
                .thenReturn(locations);

        List<ProductLocationDto> result = service
                .getProductLocationsByType(user, BatchOrder.C, idProduct);

        assertEquals(2, result.size());
    }

    @Test
    void getProductLocationsByType_orderByDueDate() {
        User user = new User();
        Long idProduct = 1L;
        List<BatchWithLocation> locations = getLocations();

        when(batchRepository.findByProductIdOrderByDueDate(user.getId(), idProduct))
                .thenReturn(locations);

        List<ProductLocationDto> result = service
                .getProductLocationsByType(user, BatchOrder.F, idProduct);

        assertEquals(2, result.size());
    }

    @Test
    void getProductLocationsByType_orderByBatch() {
        User user = new User();
        Long idProduct = 1L;
        List<BatchWithLocation> locations = getLocations();

        when(batchRepository.findByProductIdOrderById(user.getId(), idProduct))
                .thenReturn(locations);

        List<ProductLocationDto> result = service
                .getProductLocationsByType(user, BatchOrder.L, idProduct);

        assertEquals(2, result.size());
    }

    private List<BatchWithLocation> getLocations() {
        return List.of(locationOne(), locationTwo(), locationThree());
    }

    private BatchWithLocation locationOne() {
        BatchWithLocationImpl batchWithLocation = new BatchWithLocationImpl();
        batchWithLocation.setWarehouseId(1L);
        batchWithLocation.setSectionId(1L);
        batchWithLocation.setProductId(1L);
        batchWithLocation.setBatchId(1L);
        batchWithLocation.setCurrentQuantity(1);
        batchWithLocation.setDueDate(LocalDate.now());
        return batchWithLocation;
    }

    private BatchWithLocation locationTwo() {
        BatchWithLocationImpl batchWithLocation = new BatchWithLocationImpl();
        batchWithLocation.setWarehouseId(1L);
        batchWithLocation.setSectionId(1L);
        batchWithLocation.setProductId(1L);
        batchWithLocation.setBatchId(1L);
        batchWithLocation.setCurrentQuantity(1);
        batchWithLocation.setDueDate(LocalDate.now());
        return batchWithLocation;
    }

    private BatchWithLocation locationThree() {
        BatchWithLocationImpl batchWithLocation = new BatchWithLocationImpl();
        batchWithLocation.setWarehouseId(1L);
        batchWithLocation.setSectionId(2L);
        batchWithLocation.setProductId(1L);
        batchWithLocation.setBatchId(1L);
        batchWithLocation.setCurrentQuantity(1);
        batchWithLocation.setDueDate(LocalDate.now());
        return batchWithLocation;
    }
}