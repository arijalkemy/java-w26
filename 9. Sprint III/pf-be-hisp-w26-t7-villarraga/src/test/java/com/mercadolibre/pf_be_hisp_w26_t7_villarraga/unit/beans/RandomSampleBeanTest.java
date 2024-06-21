package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.unit.beans;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.beans.RandomSampleBean;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
