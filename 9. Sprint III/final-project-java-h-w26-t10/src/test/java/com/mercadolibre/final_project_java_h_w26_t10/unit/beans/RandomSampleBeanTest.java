package com.mercadolibre.final_project_java_h_w26_t10.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.final_project_java_h_w26_t10.beans.RandomSampleBean;
import com.mercadolibre.final_project_java_h_w26_t10.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
