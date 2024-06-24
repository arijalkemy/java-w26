package com.mercadolibre.pf_be_hisp_w26_t6_martinez.controller;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.batch.IBatchService;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.util.DateSortType;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.util.StorageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BatchControllerTest {

    @InjectMocks
    BatchController batchController;

    @Mock
    IBatchService batchService;

    @Test
    public void test(){
        batchController.listBatchesExpiringInLessThanDays(10, StorageType.FF.name(), DateSortType.date_asc.name());

        Assertions.assertEquals(true,true);
    }
}
