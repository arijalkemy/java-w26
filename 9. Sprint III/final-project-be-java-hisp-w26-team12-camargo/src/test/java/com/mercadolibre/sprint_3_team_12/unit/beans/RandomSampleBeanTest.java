package com.mercadolibre.sprint_3_team_12.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.sprint_3_team_12.beans.RandomSampleBean;
import com.mercadolibre.sprint_3_team_12.dto.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
