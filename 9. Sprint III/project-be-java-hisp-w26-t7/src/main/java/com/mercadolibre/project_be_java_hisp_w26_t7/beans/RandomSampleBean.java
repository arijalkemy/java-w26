package com.mercadolibre.project_be_java_hisp_w26_t7.beans;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.SampleDTO;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Component;

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
