package com.mercadolibre.pf_be_hisp_w26_t07_torres.beans;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.SampleDTO;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Sample Bean class.
 */
@Component
public class RandomSampleBean {

  /**
   * @return new instance of SampleDTO.
   */
  public SampleDTO random() {
    return new SampleDTO(ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE));
  }
}
