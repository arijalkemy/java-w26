package com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.beans;

import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Component;

import com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.dto.SampleDTO;

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
