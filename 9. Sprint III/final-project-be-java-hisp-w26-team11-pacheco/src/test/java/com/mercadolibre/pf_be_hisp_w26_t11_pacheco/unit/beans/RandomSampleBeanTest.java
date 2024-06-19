package com.mercadolibre.pf_be_hisp_w26_t11_pacheco.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.pf_be_hisp_w26_t11_pacheco.beans.RandomSampleBean;
import com.mercadolibre.pf_be_hisp_w26_t11_pacheco.dto.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
