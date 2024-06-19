package com.mercadolibre.sprint_3_team_12_malacara.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.sprint_3_team_12_malacara.beans.RandomSampleBean;
import com.mercadolibre.sprint_3_team_12_malacara.dto.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
