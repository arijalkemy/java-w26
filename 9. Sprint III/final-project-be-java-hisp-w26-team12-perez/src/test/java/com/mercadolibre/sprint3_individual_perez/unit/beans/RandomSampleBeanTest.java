package com.mercadolibre.sprint3_individual_perez.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.sprint3_individual_perez.beans.RandomSampleBean;
import com.mercadolibre.sprint3_individual_perez.dto.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
