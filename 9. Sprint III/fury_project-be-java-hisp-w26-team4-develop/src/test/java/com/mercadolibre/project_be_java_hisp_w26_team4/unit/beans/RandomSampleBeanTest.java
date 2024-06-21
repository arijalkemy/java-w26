package com.mercadolibre.project_be_java_hisp_w26_team4.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.project_be_java_hisp_w26_team4.beans.RandomSampleBean;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
