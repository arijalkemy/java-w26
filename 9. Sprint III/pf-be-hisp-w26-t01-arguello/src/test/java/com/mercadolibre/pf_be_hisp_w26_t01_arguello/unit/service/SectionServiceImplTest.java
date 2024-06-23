package com.mercadolibre.pf_be_hisp_w26_t01_arguello.unit.service;


import com.mercadolibre.pf_be_hisp_w26_t01_arguello.entity.Section;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.entity.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.repository.ISectionRepository;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.service.SectionServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.service.interfaces.IBatchService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SectionServiceImplTest {


    @Mock
    private  ISectionRepository sectionRepository;

    @Mock
    private  IBatchService batchService;

    @InjectMocks
    private SectionServiceImpl sectionService;


    @Test
    void searchSectionById_Ok(){
        Section s = new Section();
        s.setId(1);
        when(sectionRepository.findById(anyInt())).thenReturn(Optional.of(s));

        //act
        Section result = sectionService.searchById(anyInt());

        //asserts
        Assertions.assertEquals(1,result.getId());

    }
    @Test
    void searchSectionById_NotFound(){

        when(sectionRepository.findById(anyInt())).thenReturn(Optional.empty());


        //asserts
        Assertions.assertThrows(ApiException.class, () -> sectionService.searchById(anyInt()));

    }

    @Test
    void searchByIdAndWarehouseId_Ok(){
        Warehouse w = new Warehouse();
        w.setId(1);
        w.setCity("Cordoba");

        Section s = new Section();
        s.setId(1);
        s.setWarehouse(w);

        when(sectionRepository.findById(1)).thenReturn(Optional.of(s));
        //act
        Section result =  sectionService.searchByIdAndWarehouseId(1,w.getId());
        //Assertions
        Assertions.assertEquals(1,result.getId());
    }

    @Test
    void searchByIdAndWarehouseId_BadRequest(){
        Warehouse w = new Warehouse();
        w.setId(2);
        w.setCity("Cordoba");

        Section s = new Section();
        s.setId(1);
        s.setWarehouse(w);

        when(sectionRepository.findById(1)).thenReturn(Optional.of(s));

        //Assertions
        Assertions.assertThrows(ApiException.class, () -> sectionService.searchByIdAndWarehouseId(1,1));
    }

    @Test
    void SearchAndValidateByWarehouseAndQuantity_Ok(){
        Warehouse w = new Warehouse();
        w.setId(1);

        Section s = new Section();
        s.setId(1);
        s.setWarehouse(w);
        s.setMaxBatchCapacity(30);

        when(sectionRepository.findById(1)).thenReturn(Optional.of(s));
        when(batchService.countBatchesBySection(s.getId())).thenReturn(3);
        //act
        Section result = sectionService.searchAndValidateByWarehouseAndQuantity(s.getId(),w.getId(),3);

        //Arrange
        Assertions.assertEquals(1,result.getId());
        Assertions.assertEquals(30,result.getMaxBatchCapacity());
    }

    @Test
    void SearchAndValidateByWarehouseAndQuantityNoSpace_BadRequest(){
        Warehouse w = new Warehouse();
        w.setId(1);

        Section s = new Section();
        s.setId(1);
        s.setWarehouse(w);
        s.setMaxBatchCapacity(10);

        when(sectionRepository.findById(1)).thenReturn(Optional.of(s));
        when(batchService.countBatchesBySection(s.getId())).thenReturn(3);

        //asserts
        Assertions.assertThrows(ApiException.class,
                () -> sectionService.searchAndValidateByWarehouseAndQuantity(s.getId(),w.getId(),8));
    }

}
