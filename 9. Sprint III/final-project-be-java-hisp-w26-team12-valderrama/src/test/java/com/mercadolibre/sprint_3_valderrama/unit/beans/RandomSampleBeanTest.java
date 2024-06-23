package com.mercadolibre.sprint_3_valderrama.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.sprint_3_valderrama.beans.RandomSampleBean;
import com.mercadolibre.sprint_3_valderrama.dto.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
