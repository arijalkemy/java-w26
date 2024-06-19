package com.mercadolibre.pf_be_hisp_w26_t10_hoyos.unit.beans;

import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.beans.RandomSampleBean;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos.SampleDTO;
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
