package com.mercadolibre.deportes_n.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.deportes_n.beans.RandomSampleBean;
import com.mercadolibre.deportes_n.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
