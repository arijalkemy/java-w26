package com.mercadolibre.pf_be_hisp_w26_t1_cassini.unit.Entities;

import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.BatchUpdateTemperatureReqDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.Batch;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.utils.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BatchTest {

    Batch batch;

    @Test
    void isWrongTemperatureTestOk(){
        Batch batch2= TestUtil.getBatchIncorrectTemperature();

        Assertions.assertTrue(batch2.isWrongTemperature());

    }
    @Test
    void isWrongTemperatureTestNoOk(){
        Batch batch1= TestUtil.getBatchCorrectTemperature();

        Assertions.assertFalse(batch1.isWrongTemperature());

    }

    @Test
    void calculateDegreesAboveMinimumNoOk(){
        Batch batch1= TestUtil.getBatchCorrectTemperature();

        Assertions.assertEquals(batch1.calculateDegreesAboveMinimum(),0.0);

    }
    @Test
    void calculateDegreesAboveMinimumOk(){
        Batch batch1= TestUtil.getBatchIncorrectTemperature();

        Assertions.assertEquals(batch1.calculateDegreesAboveMinimum(),4.0);

    }




}
