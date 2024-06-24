package com.mercadolibre.final_project_java_hisp_w26_t6.beans;

import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.SampleDTO;
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
