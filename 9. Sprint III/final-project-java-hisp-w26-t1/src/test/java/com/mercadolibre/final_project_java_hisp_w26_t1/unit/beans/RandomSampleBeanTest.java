package com.mercadolibre.final_project_java_hisp_w26_t1.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.final_project_java_hisp_w26_t1.beans.RandomSampleBean;
import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
