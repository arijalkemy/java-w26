package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.beans.RandomSampleBean;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
