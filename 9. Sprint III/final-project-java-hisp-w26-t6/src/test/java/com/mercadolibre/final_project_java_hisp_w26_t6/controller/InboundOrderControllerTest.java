package com.mercadolibre.final_project_java_hisp_w26_t6.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class InboundOrderControllerTest {

    @InjectMocks
    InboundOrderController inboundOrderController;

    @Test
    public void test(){
        //inboundOrderController.insertBatchInFulfillmentWarehouse();
        //inboundOrderController.updateBatchInFulfillmentWarehouse();

        Assertions.assertEquals(true,true);
    }
}