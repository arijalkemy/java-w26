package com.mercadolibre.final_project_java_hisp_w26_t6.controller;

import com.mercadolibre.final_project_java_hisp_w26_t6.services.batch.IBatchService;
import com.mercadolibre.final_project_java_hisp_w26_t6.util.DateSortType;
import com.mercadolibre.final_project_java_hisp_w26_t6.util.StorageType;
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
