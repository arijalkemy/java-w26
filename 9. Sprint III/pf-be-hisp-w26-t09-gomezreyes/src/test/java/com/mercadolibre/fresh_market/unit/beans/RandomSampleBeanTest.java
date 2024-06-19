package com.mercadolibre.fresh_market.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.fresh_market.beans.RandomSampleBean;
import com.mercadolibre.fresh_market.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
