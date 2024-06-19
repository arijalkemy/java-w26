package com.mercadolibre.meli_frescos.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.meli_frescos.beans.RandomSampleBean;
import com.mercadolibre.meli_frescos.dto.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
