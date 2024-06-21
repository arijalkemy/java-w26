package com.mercadolibre.pf_be_hisp_w26_t1_cassini.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.pf_be_hisp_w26_t1_cassini.beans.RandomSampleBean;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
